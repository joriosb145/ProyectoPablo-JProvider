package cr.ac.utn.jprovider.util

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import cr.ac.utn.jprovider.R

class util {
    companion object {
        fun OpenActivity(context: Context, classActivity: Class<*>) {
            val objIntent = Intent(context, classActivity)
            context.startActivity(objIntent)
        }

        fun showDialogCondition(context: Context, questionText: String, callback: () -> Unit) {
            val dialogBuilder = AlertDialog.Builder(context)
            dialogBuilder.setMessage(questionText)
                .setCancelable(false)
                .setPositiveButton(context.getString(R.string.dialog_yes)) { _, _ -> callback() }
                .setNegativeButton(context.getString(R.string.dialog_no)) { dialog, _ -> dialog.cancel() }

            val alert = dialogBuilder.create()
            alert.setTitle(context.getString(R.string.dialog_title))
            alert.show()
        }
    }
}
