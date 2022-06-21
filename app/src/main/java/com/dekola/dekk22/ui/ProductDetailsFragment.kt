package com.dekola.dekk22.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.PagerSnapHelper
import com.dekola.dekk22.data.model.ProductPresentation
import com.dekola.dekk22.databinding.FragmentProductDetailsBinding
import com.dekola.dekk22.ui.adapters.ProductImagesAdapter

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ProductDetailsFragment : Fragment() {

    private val productImageAdapter by lazy { ProductImagesAdapter() }

    private var _binding: FragmentProductDetailsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentProductDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViews()

        arguments?.let { bundle->
            val product = ProductDetailsFragmentArgs.fromBundle(bundle).product
            setProductViews(product)
        }
    }

    private fun setViews() {
        with(binding){
            productImagesRv.adapter = productImageAdapter
            PagerSnapHelper().attachToRecyclerView(productImagesRv)
        }
    }

    private fun setProductViews(product: ProductPresentation) {
        productImageAdapter.submitList(product.imageUrlList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}