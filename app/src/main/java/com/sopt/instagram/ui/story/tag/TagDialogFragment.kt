package com.sopt.instagram.ui.story.tag

import android.os.Bundle
import android.view.View
import com.sopt.instagram.R
import com.sopt.instagram.databinding.FragmentTagDialogBinding
import com.sopt.instagram.util.binding.BindingBottomSheetDialog

class TagDialogFragment :
    BindingBottomSheetDialog<FragmentTagDialogBinding>(R.layout.fragment_tag_dialog) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        @JvmStatic
        fun newInstance() = TagDialogFragment()
    }
}
