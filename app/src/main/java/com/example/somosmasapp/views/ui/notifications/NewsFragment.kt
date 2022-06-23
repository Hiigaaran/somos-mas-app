package com.example.somosmasapp.views.ui.notifications


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemChangeListener
import com.denzcoskun.imageslider.models.SlideModel
import com.example.somosmasapp.data.dto.News
import com.example.somosmasapp.databinding.FragmentNewsBinding

class NewsFragment : Fragment() {

    private var _binding: FragmentNewsBinding? = null
    private val viewModel: NewsViewModel by viewModels(
        factoryProducer = {
            NewsViewModelFactory()
        }
    )
    private var newsList = ArrayList<News>()
    private var slideModels = ArrayList<SlideModel>()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentNewsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        onCreateViewGetData()

        binding.imageSlider.setItemChangeListener(object: ItemChangeListener {
            override fun onItemChanged(position: Int) {
                searchContentByUrl(slideModels.get(position).imageUrl)
            }

        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun onCreateViewGetData() {
        viewModel.getNews()
        viewModel.success.observe(viewLifecycleOwner) {
                value ->
            if (null != value) {
                if (value) {
                    viewModel.data.value?.let {
                        newsList = it
                        newsList.forEach { news ->
                            if(null != news.image) {
                                slideModels.add(SlideModel(news.image.replace("http","https"), ScaleTypes.FIT))
                            }
                        }
                        binding.imageSlider.setImageList(slideModels)
                        binding.txtNombreNovedad.text = newsList.get(0).name
                        binding.txtTextoNovedad.text = newsList.get(0).content
                    }
                }
            }
        }
    }

    fun searchContentByUrl(url: String?) {
        newsList.forEach {
            news -> url.let {
            if (news.image.equals(url?.replace("https", "http"))) {
                binding.txtNombreNovedad.text = news.name
                binding.txtTextoNovedad.text = news.content
            }
        }
        }
    }
}
