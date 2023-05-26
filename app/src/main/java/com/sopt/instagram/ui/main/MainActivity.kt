package com.sopt.instagram.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.sopt.instagram.R
import com.sopt.instagram.databinding.ActivityMainBinding
import com.sopt.instagram.ui.dm.DmActivity
import com.sopt.instagram.ui.home.HomeFragment
import com.sopt.instagram.ui.newpost.NewPostActivity
import com.sopt.instagram.util.binding.BindingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {
    private var dmUnreadCount = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initStatusBarColor()
        initBnvItemSelectedListener()
        initToolBar()
        initBadge()
    }

    private fun initStatusBarColor() {
        // TODO: use WindowInsetsController instead of systemUiVisibility
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    }

    private fun initBnvItemSelectedListener() {
        supportFragmentManager.findFragmentById(R.id.fcv_main)
            ?: supportFragmentManager.beginTransaction().add(R.id.fcv_main, HomeFragment()).commit()
        binding.bnvMain.setOnItemSelectedListener { menu ->
            when (menu.itemId) {
                R.id.menu_new_post -> {
                    startActivity(Intent(this, NewPostActivity::class.java))
                }

                else -> {}
            }
            return@setOnItemSelectedListener true
        }
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
        when (item.itemId) {
            R.id.menu_toolbar_dm -> {
                moveToDm()
            }

            else -> {
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun moveToDm() {
        val intent = Intent(this, DmActivity::class.java)
        getResultSignUp.launch(intent)
    }

    private val getResultSignUp = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult(),
    ) { result: ActivityResult ->
        if (result.resultCode == RESULT_OK) {
            dmUnreadCount = result.data?.getIntExtra(DM_UNREAD_COUNT, 5)!!
        }
    }

    private fun initBadge() {
        val bottomNavigationBadge = binding.bnvMain.getOrCreateBadge(R.id.menu_mypage)
        val toolbarBadge = binding.tbMain

        if (dmUnreadCount != 0) {
            bottomNavigationBadge.backgroundColor = ContextCompat.getColor(this, R.color.red)
        }
    }

    companion object {
        private const val DM_UNREAD_COUNT = "dmUnreadCount"
    }
}
