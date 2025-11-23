package gal.uvigo.networking_example.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import gal.uvigo.networking_example.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private val viewModel: CountryViewModel by viewModels()
    private lateinit var binding: FragmentSearchBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSearch.setOnClickListener {
            val query = binding.editTextCountryName.text.toString()
            viewModel.searchCountry(query)
        }

        // TODO 06. We observe changes in the list of countries so when it changes we update the UI.
        viewModel.countries.observe(viewLifecycleOwner) { countries ->
            // TODO 06.01. We update the UI with the data from the the first country in the list.
            binding.country = countries.firstOrNull()
            // TODO 06.02. We load the flag image using Glide.
            Glide.with(this).load(binding.country?.flags?.png).into(binding.imageViewDetailFlag)
        }

        viewModel.error.observe(viewLifecycleOwner) { errorMsg ->
            if (errorMsg != null) {
                Toast.makeText(requireContext(), errorMsg, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
