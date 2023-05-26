package com.sopt.instagram.ui.newpost

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.ItemTouchHelper
import com.sopt.instagram.R
import com.sopt.instagram.databinding.ActivityNewPostBinding
import com.sopt.instagram.util.binding.BindingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewPostActivity :
    BindingActivity<ActivityNewPostBinding>(R.layout.activity_new_post),
    BackButtonDialogInterface {
    private val itemTouchHelper by lazy { ItemTouchHelper(ItemTouchCallback(NewPostImageAdapter())) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initToolbar()
        initNewPostImageAdapter()
    }

    private fun initToolbar() {
        setSupportActionBar(binding.tbNewpostToolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowTitleEnabled(false)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_newpost_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_check -> {
                if (!isFinishing) finish()
            }

            else -> {
                val dialog = BackButtonDialog(this)
                dialog.show(supportFragmentManager, "BackButtonDialog")
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onClickDeleteButton(id: Int) {
        if (!isFinishing) finish()
    }

    private fun initNewPostImageAdapter() {
        binding.rvNewpostImage.adapter = NewPostImageAdapter().apply {
            submitList(
                listOf(
                    "https://reqres.in/img/faces/7-image.jpg",
                    "https://reqres.in/img/faces/8-image.jpg",
                    "https://reqres.in/img/faces/9-image.jpg",
                ),
            )
        }
        itemTouchHelper.attachToRecyclerView(binding.rvNewpostImage)
    }
}
