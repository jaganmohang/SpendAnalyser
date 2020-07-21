/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jagan.spendanalayser.di.module

import android.app.Application
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.room.Room
import com.jagan.spendanalayser.data.db.SpendAnalyserDB
import com.jagan.spendanalayser.data.db.SpendAnalyserDB.Companion.DB_NAME
import com.jagan.spendanalayser.data.db.dao.BudgetDao
import com.jagan.spendanalayser.data.db.dao.CategoryDao
import com.jagan.spendanalayser.data.db.dao.SpendDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {

    @Singleton
    @Provides
    fun provideDb(app: Application): SpendAnalyserDB {
        return Room
            .databaseBuilder(app, SpendAnalyserDB::class.java, DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideSpendDao(db: SpendAnalyserDB): SpendDao {
        return db.spendDao()
    }

    @Singleton
    @Provides
    fun provideCategoryDao(db: SpendAnalyserDB): CategoryDao {
        return db.categoryDao()
    }

    @Singleton
    @Provides
    fun provideBudgetDao(db: SpendAnalyserDB): BudgetDao {
        return db.budgetDao()
    }

    @Singleton
    @Provides
    fun provideSharedPreferences(app: Application): SharedPreferences {
        return app.applicationContext.getSharedPreferences("EAPrefs", MODE_PRIVATE)
    }
}
