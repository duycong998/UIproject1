package com.example.testaddfragment.screen.home

import android.os.AsyncTask
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testaddfragment.R
import com.example.testaddfragment.data.model.adapter
import com.example.testaddfragment.data.model.categories
import kotlinx.android.synthetic.main.fragment_home.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.MalformedURLException
import java.net.URL

class HomeFragment : Fragment() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    lateinit var adapter: adapter
    var arrayList = ArrayList<categories>()
    lateinit var layoutManager : LinearLayoutManager
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       var v = inflater.inflate(R.layout.fragment_home, container, false)
//       var toolbar = v.findViewById<Toolbar>(R.id.toolbarSearchBH)
//        //set lại toolbar
//        (activity as AppCompatActivity).setSupportActionBar(toolbar)
//        setHasOptionsMenu(true)
        Read().execute("https://www.themealdb.com/api/json/v1/1/categories.php")
       return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Read().execute("https://www.themealdb.com/api/json/v1/1/categories.php")
    }

    inner class Read : AsyncTask<String, Void, String>() {
        override fun doInBackground(vararg p0: String?): String {
            val content = StringBuilder()
            try {
                val url = URL(p0.get(0))
                val inputStreamReader = InputStreamReader(url.openConnection().getInputStream())
                val bufferedReader = BufferedReader(inputStreamReader)
                var line: String? = ""
                while (bufferedReader.readLine().also { line = it } != null)
                 {
                    content.append(line)
                }
                bufferedReader.close()
            } catch (e: MalformedURLException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }
            return content.toString()
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            val objectt = JSONObject(result)
            val array:JSONArray = objectt.getJSONArray("categories")
            for (i:Int in 0 until array.length()){
                val object2 = array.getJSONObject(i)
                var idCategory = object2.getString("idCategory")
                var strCategory = object2.getString("strCategory")
                var strCategoryThumb = object2.getString("strCategoryThumb")
                var strCategoryDescription = object2.getString("strCategoryDescription")
                arrayList.add(categories(idCategory, strCategory, strCategoryThumb, strCategoryDescription))
                layoutManager = LinearLayoutManager(activity)
                recyclerView.layoutManager = layoutManager
                recyclerView.setHasFixedSize(true)
                adapter = activity?.let { adapter(it, arrayList) }!!
                recyclerView.adapter = adapter
                adapter.notifyDataSetChanged()
            }
        }

    }
}