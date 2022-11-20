package com.example.dialogs.helpers

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog
import com.example.dialogs.R

/**
 * Created by Sam Naduiev on 11/6/2022.
 */
object DialogHelper {

	fun getAlertDialogBuilder(context: Context):AlertDialog.Builder {
		return AlertDialog.Builder(context).setCancelable(false)
	}

	fun getSimpleOkDialog(context: Context): AlertDialog.Builder {
		return getSimpleDialog(context).setPositiveButton(R.string.btn_ok, null)
	}

	fun getContinueDialog(
		context: Context,
		okListener: DialogInterface.OnClickListener,
		negativeListener: DialogInterface.OnClickListener
	): AlertDialog.Builder {
		return getSimpleDialog(context)
			.setPositiveButton(R.string.btn_ok, okListener)
			.setNegativeButton(R.string.btn_cancel, negativeListener)
	}

	private fun getSimpleDialog(context: Context): AlertDialog.Builder {
		return AlertDialog.Builder(context)
			.setCancelable(true)
			.setTitle(R.string.t_simple_test)
			.setMessage(R.string.msg_simple_test)
	}

}