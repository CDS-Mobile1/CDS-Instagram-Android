package com.sopt.instagram.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.sopt.instagram.R
import com.sopt.instagram.databinding.ActivityMainBinding
import com.sopt.instagram.ui.home.HomeFragment
import com.sopt.instagram.ui.newpost.NewPostActivity
import com.sopt.instagram.util.binding.BindingActivity

class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initBnvItemSelectedListener()
        initToolBar()
    }

    private fun initBnvItemSelectedListener() {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fcv_main)
        if (currentFragment == null) {
            supportFragmentManager.beginTransaction().add(R.id.fcv_main, HomeFragment()).commit()
        }
        binding.bnvMain.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_home -> {
                    this.changeFragment(HomeFragment())
                }

                R.id.menu_new_post -> {
                    startActivity(Intent(this, NewPostActivity::class.java))
                }

                else -> {
                    // 아무것도 없음
                }
            }
            return@setOnItemSelectedListener true
        }
    }


    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fcv_main, fragment)
            .commit()
    }

    private fun initToolBar() {
        setSupportActionBar(binding.tbMain)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }
}
