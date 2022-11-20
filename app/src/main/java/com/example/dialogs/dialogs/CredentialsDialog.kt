package com.example.dialogs.dialogs

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import com.example.dialogs.R
import com.example.dialogs.databinding.DialodCredentialsBinding
import com.example.dialogs.helpers.DialogHelper

/**
 * Created by Sam Naduiev on 11/20/2022.
 */

class CredentialsDialog(
	private val listener: ((name: String, surname: String) -> Unit)? = null
) : DialogFragment() {

	private lateinit var binding: DialodCredentialsBinding

	override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
		binding = DialodCredentialsBinding.inflate(LayoutInflater.from(context))
		if (listener == null) dismiss()
		initStandardText()

		return DialogHelper.getAlertDialogBuilder(requireContext())
			.setTitle(R.string.t_enter_the_credentials)
			.setView(binding.root)
			.setPositiveButton(R.string.btn_ok) { _, _ ->
				val name: String = binding.tietName.text?.toString() ?: ""
				val surname: String = binding.tietSurname.text?.toString() ?: ""

				listener?.invoke(name, surname)
			}
			.setNegativeButton(R.string.btn_cancel, null)
			.create()
	}

	private fun initStandardText() {
		binding.apply {
			tietName.setText(requireArguments().getString(KEY_NAME))
			tietSurname.setText(requireArguments().getString(KEY_SURNAME))
		}
	}

	companion object {
		private const val KEY_NAME = "KEY_NAME"
		private const val KEY_SURNAME = "KEY_SURNAME"
		const val TAG = "CredentialsDialog"

		fun newInstance(
			listener: ((name: String, surname: String) -> Unit),
			defaultName: String,
			defaultSurname: String
		): CredentialsDialog {
			return CredentialsDialog(listener).also {
				it.arguments = Bundle().apply {
					putString(KEY_NAME, defaultName)
					putString(KEY_SURNAME, defaultSurname)
				}
			}
		}
	}

}