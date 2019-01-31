package com.bignerdranch.android.beatbox


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

abstract class SingleFragmentActivity : AppCompatActivity() {

    protected fun getLayoutResId() = R.layout.activity_fragment

    protected abstract fun createFragment(): Fragment

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())

        val manager = supportFragmentManager
        var fragment: Fragment? = manager.findFragmentById(R.id.fragment_container)

        if (fragment == null) {
            fragment = createFragment()
            manager.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit()
        }
    }
}
