package uz.gita.b5mynoteapp.app

import android.app.Application
import uz.gita.b5mynoteapp.data.local.MyDatabase
import uz.gita.b5mynoteapp.domain.repository.impl.RepositoryIMpl

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        MyDatabase.init(this)
        RepositoryIMpl.init()
    }
}