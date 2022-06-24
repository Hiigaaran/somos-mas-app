package com.example.somosmasapp.views.ui.contact

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.somosmasapp.R
import com.example.somosmasapp.data.dto.Contact
import com.example.somosmasapp.databinding.FragmentContactBinding
import com.example.somosmasapp.views.HomeActivity

class ContactFragment : Fragment() {

    private var _binding: FragmentContactBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: ContactViewModel by viewModels(
        factoryProducer = {
            ContactViewModelFactory() }
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentContactBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.spinnerLoading.isVisible = false
        binding.textInputName.addTextChangedListener {
            viewModel.check(
                binding.textInputName.text.toString(),
                binding.textInputEmail.text.toString(),
                binding.textInputMensaje.text.toString()
            )
        }
        binding.textInputEmail.addTextChangedListener {
            viewModel.check(
                binding.textInputName.text.toString(),
                binding.textInputEmail.text.toString(),
                binding.textInputMensaje.text.toString()
            )
        }
        binding.textInputMensaje.addTextChangedListener {
            viewModel.check(
                binding.textInputName.text.toString(),
                binding.textInputEmail.text.toString(),
                binding.textInputMensaje.text.toString()
            )
        }

        binding.enviarMje.setOnClickListener {
            val contact = Contact(
                null,
                binding.textInputName.text.toString(),
                binding.textInputEmail.text.toString(),
                null,
                binding.textInputMensaje.text.toString(),
                null,
                null,
                null
            )
            viewModel.sendContact(contact)
            viewModel.success.observe(viewLifecycleOwner) { value ->
                if (null != value) {
                    if (value) {
                        showDialog(root)
                    }
                }
            }
        }

        viewModel.spinnerView.observe(viewLifecycleOwner){ value->
            binding.spinnerLoading.isVisible = value
        }

        viewModel.blockButton.observe(viewLifecycleOwner){ value->
            binding.enviarMje.isEnabled = !value
            if(value){
                binding.enviarMje.setBackgroundColor(Color.GRAY)
            }else{
                binding.enviarMje.setBackgroundColor(Color.RED)
            }
        }
        return root
    }

    private fun showDialog(root : View){
        val alertDialog = AlertDialog.Builder(root.context)
        val errDialog = layoutInflater.inflate(R.layout.fragment_contact_dialog,null)
        alertDialog.setView(errDialog)
        val dialog = alertDialog.create()
        dialog.show()

        val okButton: Button = errDialog.findViewById(R.id.okContactBtn)
        okButton.setOnClickListener {
            dialog.dismiss()
            super.onDestroyView()
            _binding = null
            val intent = Intent(root.context, HomeActivity::class.java).apply{
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            }
            startActivity(intent)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}