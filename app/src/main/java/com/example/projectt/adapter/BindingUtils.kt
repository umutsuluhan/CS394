package com.example.projectt.adapter

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.projectt.database.PrivateLesson
import com.example.projectt.database.Renovation

@BindingAdapter("renovationName")
fun TextView.setRenovationName(item: Renovation) {
    text = item.name
}
@BindingAdapter("renovationPrice")
fun TextView.setRenovationPrice(item: Renovation) {
    text = item.price.toString()
}
@BindingAdapter("renovationAddress")
fun TextView.setRenovationAddress(item: Renovation) {
    text = item.address
}
@BindingAdapter("renovationRating")
fun TextView.setRenovationRating(item: Renovation) {
    text = item.rating.toString()
}
@BindingAdapter("privateLessonName")
fun TextView.setPrivateLessonName(item: PrivateLesson) {
    text = item.name
}
@BindingAdapter("privateLessonPrice")
fun TextView.setPrivateLessonPrice(item: PrivateLesson) {
    text = item.price.toString()
}
@BindingAdapter("privateLessonAddress")
fun TextView.setPrivateLessonAddress(item: PrivateLesson) {
    text = item.address
}
@BindingAdapter("privateLessonRating")
fun TextView.setPrivateLessonRating(item: PrivateLesson) {
    text = item.rating.toString()
}
