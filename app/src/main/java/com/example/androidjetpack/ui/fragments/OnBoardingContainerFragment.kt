package com.example.androidjetpack.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.androidjetpack.R
import com.example.androidjetpack.data.OnBoarding
import com.example.androidjetpack.databinding.FragmentOnboardingBinding
import com.example.androidjetpack.ui.adapters.OnBoardingSlidePagerAdapter

class OnBoardingContainerFragment : Fragment() {

    private var _binding: FragmentOnboardingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        crearViewPager()
        binding.textViewHome.setOnClickListener {
            findNavController().navigate(R.id.goToPeliculas)
        }
    }

    private fun crearViewPager() {
        val fragments = crearFragmentosOnBoarding()
        val adapter = OnBoardingSlidePagerAdapter(
            fragments,
            requireActivity().supportFragmentManager,
            lifecycle
        )
        binding.viewPager.adapter = adapter
    }

    private fun crearFragmentosOnBoarding() = listOf(
        OnBoardingContentFragment.newInstance(
            OnBoarding(
                R.drawable.onboarding_1,
                "Bienvenido!!",
                "En esta app encontrarás todo lo que necesitas para almacenar las peliculas que desees ver o que te hayan gustado"
            )
        ),
        OnBoardingContentFragment.newInstance(
            OnBoarding(
                R.drawable.onboarding_2,
                "Calidad",
                "Esta app fue construida aplicando las librerías de Jetpack propuestas y creadas por Google."
            )
        )
    )
}