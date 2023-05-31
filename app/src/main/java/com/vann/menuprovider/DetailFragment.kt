package com.vann.menuprovider

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.navigation.fragment.findNavController

class DetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val menuHost: MenuHost = requireActivity();

        menuHost.addMenuProvider(object : MenuProvider {
            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when (menuItem.itemId) {
                    R.id.setting -> Toast.makeText(context, "Setting", Toast.LENGTH_SHORT).show()
                }
                return false
            }

            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.optionmenu, menu)
                menu.findItem(R.id.setting).isVisible = true
            }
        }, viewLifecycleOwner)

        return inflater.inflate(R.layout.fragment_detail, container, false)
    }
}