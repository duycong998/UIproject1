package com.example.generic

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val student: Student = Student("name")


//        var array: ArrayList<String> = arrayListOf()
////        array.add("cong")
////        array.add(2)
////        array.add(student.name)
//        showArray(array)
//        showArray(2)

        var arrayString: ArrayList<String> = arrayListOf("ac", "b", "c")
        var arrayInt: ArrayList<Int> = arrayListOf(1, 2, 6, 9)
        var arrayDouble: ArrayList<Double> = arrayListOf(1.2, 2.3, 5.9, 7.8)

        var max = max(arrayString)
        Log.d("bbb","max :" + max)


//        showArray(arrayInt)
//        showArray(arrayDouble)
//        showArray(arrayString)

//
//        val test : MainActivity = MainActivity()
//        test.showInfo("aaa",1)
//        test.showInfo(1,"kimochi")
//        test.showInfo(2,arrayDouble)


//        Log.d("aaa","" + array.size)
//        var arraya: ArrayList<String> = arrayListOf("1", "2")
//        for (item in arraya) {
//            Log.d("aa",""+ item)
//
//        }
    }

    fun <K, V> showInfo(k: K, v: V)  {
        Log.d("aaa",  "result : " + v + ":" + k)

    }

    fun <T> showArray(ts: T) : T {  // T = type
        var array = arrayListOf(ts)
        for (i in array) {
            Log.d("aa", "" + i)
        }
        return ts
    }

//    fun  showArray(any: Any) {
//        var any = arrayListOf(any)
//        for (  ob in any) {
//            Log.d("aa",""+ob)
//        }
//
//    }
//
//    fun <T : Comparable<T>> max(a: ArrayList<T>): T {
//        var max = a[0]
//        for (i in a) {
//            if (i!! > max) {
//                max = i
//            }
//        }
//        return max
//    }

    fun <T : Comparable<T>> max (a: ArrayList<T>) : T {
        var max = a[0]
        for(i in a) {
            if(i > max) {
                max = i
            }
        }
        return max
    }

}



                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               