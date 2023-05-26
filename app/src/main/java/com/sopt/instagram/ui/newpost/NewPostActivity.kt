package com.sopt.instagram.ui.newpost

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.recyclerview.widget.ItemTouchHelper
import com.sopt.instagram.R
import com.sopt.instagram.databinding.ActivityNewPostBinding
import com.sopt.instagram.ui.main.MainActivity
import com.sopt.instagram.util.UiState
import com.sopt.instagram.util.binding.BindingActivity
import com.sopt.instagram.util.extension.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewPostActivity :
    BindingActivity<ActivityNewPostBinding>(R.layout.activity_new_post),
    BackButtonDialogInterface {
    private val itemTouchHelper by lazy { ItemTouchHelper(ItemTouchCallback(NewPostImageAdapter())) }
    private val viewModel by viewModels<NewPostViewModel>()

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
                viewModel.onClickCheckButton(binding.etNewpostContents.text.toString())
                viewModel.postNewPostState.observe(this) { state ->
                    when (state) {
                        is UiState.Success -> {
                            startActivity(Intent(this, MainActivity::class.java))
                            if (!isFinishing) finish()
                        }

                        is UiState.Failure -> {
                            showToast("erererer")
                        }

                        is UiState.Error -> {
                            showToast("error")
                        }
                    }
                }
            }

            else -> {
                val dialog = BackButtonDialog(this)
                dialog.show(supportFragmentManager, "BackButtonDialog")
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onClickDeleteButton(id: Int) {
        startActivity(Intent(this, MainActivity::class.java))
        if (!isFinishing) finish()
    }

    private fun initNewPostImageAdapter() {
        binding.rvNewpostImage.adapter = NewPostImageAdapter().apply {
            submitList(
                viewModel.mockImage,
            )
        }
        itemTouchHelper.attachToRecyclerView(binding.rvNewpostImage)
    }
}
