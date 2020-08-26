package com.example.testaddfragment.screen.tablelayout

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.example.testaddfragment.R
import com.example.testaddfragment.screen.detail.DetailFragment
import com.example.testaddfragment.screen.favorite.FavoriteFragment
import com.example.testaddfragment.screen.home.HomeFragment
import com.example.testaddfragment.screen.main.PagerAdapterFragment
import com.example.testaddfragment.screen.search.SearchFragment
import kotlinx.android.synthetic.main.fragment_tab.*

class TableLayoutFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v = inflater.inflate(R.layout.fragment_tab, container, false)
        var toolbar = v.findViewById<Toolbar>(R.id.toolbarSearchBH)
        //set lại toolbar
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        setHasOptionsMenu(true)
        return v

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.search_menu, menu)
        val menuItem = menu.findItem(R.id.menuSearch)
        val searchView = menuItem.actionView as SearchView
        searchView.maxWidth = Int.MAX_VALUE
        searchView.setBackgroundResource(R.drawable.customsearch)
        searchView.queryHint = "Search for name, Area"
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
//                searchKeySong(query);
//                return true;
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                // searchKeySong(newText)
                return true
                //   return false;
            }
        })
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       setupTabLayout()
    }

    private fun setupTabLayout() {
        setupViewPager()
        tabLayout.setupWithViewPager(viewPager)
        setupTabIcons()

    }

    private fun setupTabIcons() {
        tabLayout.getTabAt(0)?.setIcon(R.drawable.ic_home)
        tabLayout.getTabAt(1)?.setIcon(R.drawable.ic_heart)

    }

    private fun setupViewPager() {
        viewPager.adapter = activity?.supportFragmentManager?.let {
            PagerAdapterFragment(it).apply {
                addFragment(HomeFragment(), "Home")
                addFragment(FavoriteFragment(), "Favorite")
                addFragment(SearchFragment(), "Search")
                addFragment(DetailFragment(), "Detail")
            }
        }

    }
}