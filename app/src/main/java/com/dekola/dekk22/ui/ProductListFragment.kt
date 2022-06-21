package com.dekola.dekk22.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.dekola.dekk22.data.model.ProductPresentation
import com.dekola.dekk22.databinding.FragmentProductListBinding
import com.dekola.dekk22.ui.adapters.ProductListAdapter
import dagger.hilt.android.AndroidEntryPoint

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */

@AndroidEntryPoint
class ProductListFragment : Fragment() {

    private val viewModel: ProductViewModel by viewModels()
    private val productListAdapter: ProductListAdapter by lazy { ProductListAdapter(::viewProductDetails) }

    private var _binding: FragmentProductListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentProductListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setView()
        setObservers()
    }

    private fun fetchProducts() {
        viewModel.getProducts()
    }

    private fun setObservers() {
        with(viewModel) {
            productsResult.observe(viewLifecycleOwner) { productsResult ->
                productsResult.success?.let { products ->
                    productListAdapter.submitList(products)
                } ?: kotlin.run {
                    showToast(productsResult.errorMessage)
                }
            }
            loadLiveData.observe(viewLifecycleOwner) { load ->
                binding.productSrl.isRefreshing = load
            }
        }
    }

    private fun showToast(errorMessage: String?) {
        Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_SHORT).show()
    }

    private fun setView() {
        with(binding) {
            productsRv.adapter = productListAdapter
            productSrl.setOnRefreshListener {
                fetchProducts()
            }
        }
    }

    private fun viewProductDetails(product: ProductPresentation) {
        findNavController().navigate(ProductListFragmentDirections.actionProductListFragmentToProductDetailsFragment(
            product))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}