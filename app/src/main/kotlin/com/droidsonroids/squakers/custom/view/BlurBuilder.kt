package pl.droidsonroids.hematoonkologia.widget.blur

import android.content.Context
import android.graphics.Bitmap
import android.renderscript.Allocation
import android.renderscript.Element
import android.renderscript.RenderScript
import android.renderscript.ScriptIntrinsicBlur

object BlurBuilder {

    fun blur(context: Context, image: Bitmap, blurScale: Float, blurRadius: Float): Bitmap {
        val width = Math.round(image.width * blurScale)
        val height = Math.round(image.height * blurScale)

        val inputBitmap = Bitmap.createScaledBitmap(image, width, height, false)
        val outputBitmap = Bitmap.createBitmap(inputBitmap)

        val rs = RenderScript.create(context)
        val theIntrinsic = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs))
        val tmpIn = Allocation.createFromBitmap(rs, inputBitmap)
        val tmpOut = Allocation.createFromBitmap(rs, outputBitmap)
        theIntrinsic.setRadius(blurRadius)
        theIntrinsic.setInput(tmpIn)
        theIntrinsic.forEach(tmpOut)
        tmpOut.copyTo(outputBitmap)

        tmpIn.destroy()
        tmpOut.destroy()
        theIntrinsic.destroy()
        rs.destroy()

        return outputBitmap
    }
}