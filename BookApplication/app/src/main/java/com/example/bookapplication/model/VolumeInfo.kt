package com.example.bookapplication.model

import com.google.gson.annotations.SerializedName

data class VolumeInfo(@SerializedName("title") val title:String?,
@SerializedName("publisher") val publisher:String?,
@SerializedName("publishedDate") val date:String?)
