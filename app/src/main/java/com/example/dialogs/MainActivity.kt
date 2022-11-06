package com.example.dialogs

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dialogs.databinding.ActivityMainBinding
import com.example.dialogs.helpers.DialogHelper

class MainActivity : AppCompatActivity() {

	private lateinit var binding: ActivityMainBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)
		initListeners()
	}

	// Views and listeners init block

	private fun initListeners() {
		binding.apply {
			btnShowSimpleOkDialog.setOnClickListener {
				DialogHelper.getSimpleOkDialog(this@MainActivity).show()
			}
			btnShowContinueDialog.setOnClickListener {
				DialogHelper.getContinueDialog(
					context = this@MainActivity,
					negativeListener = { _, _ ->
						Toast.makeText(
							this@MainActivity,
							"The process was canceled",
							Toast.LENGTH_SHORT
						).show()
					},
					okListener = { _, _ ->
						Toast.makeText(
							this@MainActivity,
							"The process was continued",
							Toast.LENGTH_SHORT
						).show()
					}).show()
			}
		}
	}

	//end block
}