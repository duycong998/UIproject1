package com.example.testaddfragment.data.model

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import java.net.HttpURLConnection
import java.net.URL

class DownloadImageRecipes(val callback: (Bitmap) -> Unit) :
    AsyncTask<String?, Void?, Bitmap?>() {

    override fun doInBackground(vararg params: String?): Bitmap? {
        var urlConnection: HttpURLConnection? = null
        return try {
            val uri = URL(params[0])
            urlConnection = uri.openConnection() as HttpURLConnection
            val inputStream = urlConnection.inputStream
            BitmapFactory.decodeStream(inputStream)
        } catch (e: Exception) {
            e.printStackTrace()
            urlConnection?.disconnect()
            null
        }
    }

    override fun onPostExecute(result: Bitmap?) {
        result?.let {
            callback(it)
        }
    }
}
