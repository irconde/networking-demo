package gal.uvigo.networking_example.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

// TODO 07. As an alternative we can define a BindingAdapter to leverage Glide right from the xml layout
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
