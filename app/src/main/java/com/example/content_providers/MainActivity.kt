package com.example.content_providers

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.MediaStore
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val page=1
    val limit=20

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getdata(page,limit)
        recyerview.layoutManager=LinearLayoutManager(this)

        btnRead.setOnClickListener{
            val contactList:MutableList<ContactDTO> =ArrayList()
            val contacts=contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null)
            if (contacts != null) {
                while (contacts.moveToNext()){

                  val name=contacts.getString(contacts.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
                  val number=contacts.getString(contacts.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))

                    val obj=ContactDTO()
                    obj.name=name
                    obj.number=number




                    contactList.add(obj)
                }
            }
            recyerview.adapter=ContactAdapter(contactList,this)

        }
    }

    private fun getdata(page: Int, limit: Int) {

    }
}