package gal.uvigo.networking_example.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object BindingAdapters {
    @JvmStatic
    @BindingAdapter("imageUrl")
    fun loadImage(view: ImageView, url: String?) {
        if (url.isNullOrEmpty()) {
            view.setImageDrawable(null)
            return
        }
        Glide.with(view).load(url).into(view)
    }
}
