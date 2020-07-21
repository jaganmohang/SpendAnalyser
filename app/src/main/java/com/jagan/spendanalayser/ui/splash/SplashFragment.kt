package com.jagan.spendanalayser.ui.splash

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.Scope
import com.google.api.client.extensions.android.http.AndroidHttp
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential
import com.google.api.client.json.gson.GsonFactory
import com.google.api.services.drive.Drive
import com.google.api.services.drive.DriveScopes
import com.jagan.spendanalayser.R
import com.jagan.spendanalayser.constants.AppConstants.Companion.REQUEST_CODE_SIGN_IN
import com.jagan.spendanalayser.databinding.SplashFragmentBinding
import com.jagan.spendanalayser.ui.MainActivity
import com.jagan.spendanalayser.ui.base.BaseFragment
import com.jagan.spendanalayser.utils.autoCleared

class SplashFragment : BaseFragment() {
    private val splashViewModel: SplashViewModel by viewModels { viewModelFactory }
    private var splashFragmentBinding by autoCleared<SplashFragmentBinding>()

    override fun getLayoutRes(): Int = R.layout.splash_fragment

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val dataBinding = DataBindingUtil.inflate<SplashFragmentBinding>(inflater, getLayoutRes(), container, false)
        splashFragmentBinding = dataBinding
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        splashFragmentBinding.clickHandler = ClickHandler()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, resultData: Intent?) {
        when (requestCode) {
            REQUEST_CODE_SIGN_IN -> if (resultCode == Activity.RESULT_OK && resultData != null) {
                handleSignInResult(resultData)
            }
        }
        super.onActivityResult(requestCode, resultCode, resultData)
    }

    /**
     * Handles the `result` of a completed sign-in activity initiated from [ ][.requestSignIn].
     */
    private fun handleSignInResult(result: Intent) {
        GoogleSignIn.getSignedInAccountFromIntent(result)
                .addOnSuccessListener { googleAccount ->
                    // Use the authenticated account to sign in to the Drive service.
                    val credential = GoogleAccountCredential.usingOAuth2(
                            activity, setOf(DriveScopes.DRIVE_FILE)
                    )
                    credential.selectedAccount = googleAccount.account
                    val googleDriveService = Drive.Builder(
                            AndroidHttp.newCompatibleTransport(),
                            GsonFactory(),
                            credential
                    ).setApplicationName("Expense Analyser")
                            .build()
                    navigateToDashboard()
                    // The DriveServiceHelper encapsulates all REST API and SAF functionality.
                    // Its instantiation is required before handling any onClick actions.
                    //mDriveServiceHelper = DriveServiceHelper(googleDriveService)
                }
                .addOnFailureListener {
                    showToast("Sign in failed...")
                    navigateToDashboard()
                }
    }

    private fun requestSignIn() {
        val signInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .requestScopes(Scope(DriveScopes.DRIVE_FILE))
                .build()
        val client = GoogleSignIn.getClient(activity!!, signInOptions)

        // The result of the sign-in Intent is handled in onActivityResult.
        startActivityForResult(client.signInIntent, REQUEST_CODE_SIGN_IN)
    }

    private fun navigateToDashboard() {
        val intent = Intent(activity!!, MainActivity::class.java)
        startActivity(intent)
        activity?.finish()
    }

    inner class ClickHandler {
        fun onChooseAccountClick() {
            requestSignIn()
        }

        fun onSkipClick() {
            navigateToDashboard()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = SplashFragment()

        @JvmStatic
        val TAG: String = SplashFragment::class.java.simpleName
    }
}
