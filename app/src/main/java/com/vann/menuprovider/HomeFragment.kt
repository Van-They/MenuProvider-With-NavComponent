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

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val menuHost: MenuHost = requireActivity();

        menuHost.addMenuProvider(object :MenuProvider{

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
               when(menuItem.itemId){
                   R.id.user->Toast.makeText(context,"User",Toast.LENGTH_SHORT).show()
                   R.id.group->Toast.makeText(context,"group",Toast.LENGTH_SHORT).show()
               }
                return false
            }


            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.optionmenu,menu)
                menu.findItem(R.id.user).isVisible = true
                menu.findItem(R.id.group).isVisible = true
            }

        },viewLifecycleOwner)



        return inflater.inflate(R.layout.fragment_home, container, false)
    }


}