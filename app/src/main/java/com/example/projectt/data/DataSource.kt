package com.example.projectt.data

import com.example.projectt.model.ListItem
import com.example.projectt.R

class Datasource {
    fun loadListItems() : List<ListItem>{
        return listOf<ListItem>(
            ListItem(R.string.listItem1, R.string.listItem1Price, R.string.listItem1address),
            ListItem(R.string.listItem2, R.string.listItem2Price, R.string.listItem2address),
            ListItem(R.string.listItem3, R.string.listItem3Price, R.string.listItem3address),
            ListItem(R.string.listItem4, R.string.listItem4Price, R.string.listItem4address),
            ListItem(R.string.listItem5, R.string.listItem5Price, R.string.listItem5address),
            ListItem(R.string.listItem6, R.string.listItem6Price, R.string.listItem6address),
            ListItem(R.string.listItem7, R.string.listItem7Price, R.string.listItem7address),
            ListItem(R.string.listItem8, R.string.listItem8Price, R.string.listItem8address),
            ListItem(R.string.listItem9, R.string.listItem9Price, R.string.listItem9address),
            ListItem(R.string.listItem10, R.string.listItem10Price, R.string.listItem10address),
            ListItem(R.string.listItem11, R.string.listItem11Price, R.string.listItem11address),
            ListItem(R.string.listItem12, R.string.listItem12Price, R.string.listItem12address),
            ListItem(R.string.listItem13, R.string.listItem13Price, R.string.listItem13address),
            ListItem(R.string.listItem14, R.string.listItem14Price, R.string.listItem14address),
            ListItem(R.string.listItem15, R.string.listItem15Price, R.string.listItem15address),
            ListItem(R.string.listItem16, R.string.listItem16Price, R.string.listItem16address),
            ListItem(R.string.listItem17, R.string.listItem17Price, R.string.listItem17address),
            ListItem(R.string.listItem18, R.string.listItem18Price, R.string.listItem18address)


        )

    }
}