package com.sopt.instagram.ui.newpost

import android.os.Bundle
import android.view.View
import com.sopt.instagram.R
import com.sopt.instagram.databinding.FragmentNewpostDialogBinding
import com.sopt.instagram.util.binding.BindingDialog

class BackButtonDialog(
    private val backButtonDialog: BackButtonDialogInterface,
) :
    BindingDialog<FragmentNewpostDialogBinding>(R.layout.fragment_newpost_dialog) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onClickSaveTemporaryButton()
        onClickDeleteButton()
    }

    private fun onClickSaveTemporaryButton() {
        binding.tvDialogSaveTemporary.setOnClickListener {
            dismiss()
        }
    }

    private fun onClickDeleteButton() {
        binding.tvDialogDelete.setOnClickListener {
            backButtonDialog.onClickDeleteButton(id)
            dismiss()
        }
    }
}

interface BackButtonDialogInterface {
    fun onClickDeleteButton(id: Int)
}
