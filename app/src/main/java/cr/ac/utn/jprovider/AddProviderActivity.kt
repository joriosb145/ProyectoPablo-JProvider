package cr.ac.utn.jprovider

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import cr.ac.utn.jprovider.domain.model.Provider
import cr.ac.utn.jprovider.util.util
import cr.ac.utn.jprovider.viewmodel.ProviderViewModel

class AddProviderActivity : AppCompatActivity() {

    private lateinit var etId: EditText
    private lateinit var etName: EditText
    private lateinit var etContact: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPhone: EditText
    private lateinit var etAddress: EditText
    private lateinit var btnDelete: Button
    private var isEditMode: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_addprovider)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        etId = findViewById(R.id.etId_addprovider)
        etName = findViewById(R.id.etName_addprovider)
        etContact = findViewById(R.id.etContact_addprovider)
        etEmail = findViewById(R.id.etEmail_addprovider)
        etPhone = findViewById(R.id.etPhone_addprovider)
        etAddress = findViewById(R.id.etAddress_addprovider)
        btnDelete = findViewById(R.id.btnDelete_addprovider)

        val btnSearch: ImageButton = findViewById(R.id.btnSearch_addprovider)
        val btnSave: Button = findViewById(R.id.btnSave_addprovider)
        val btnCancel: Button = findViewById(R.id.btnCancel_addprovider)
        val btnClear: Button = findViewById(R.id.btnClear_addprovider)

        btnDelete.isVisible = isEditMode

        btnSearch.setOnClickListener(View.OnClickListener { view ->
            searchProvider(etId.text.toString().trim())
        })

        btnSave.setOnClickListener(View.OnClickListener { view ->
            if (isEditMode) {
                util.showDialogCondition(this, getString(R.string.dialog_update_question)) { saveProvider() }
            } else {
                saveProvider()
            }
        })

        btnDelete.setOnClickListener(View.OnClickListener { view ->
            util.showDialogCondition(this, getString(R.string.dialog_delete_question)) { deleteProvider() }
        })

        btnClear.setOnClickListener(View.OnClickListener { view ->
            cleanScreen()
        })

        btnCancel.setOnClickListener(View.OnClickListener { view ->
            finish()
        })
    }

    private fun searchProvider(id: String) {
        val provider = ProviderViewModel.getProviderById(id)
        if (provider != null) {
            isEditMode = true
            etId.isEnabled = false
            etName.setText(provider.name)
            etContact.setText(provider.contactPerson)
            etEmail.setText(provider.email)
            etPhone.setText(provider.phoneNumber)
            etAddress.setText(provider.address)
            btnDelete.isVisible = true
        } else {
            Toast.makeText(this, getString(R.string.msg_provider_not_found), Toast.LENGTH_LONG).show()
        }
    }

    private fun cleanScreen() {
        isEditMode = false
        etId.isEnabled = true
        etId.setText("")
        etName.setText("")
        etContact.setText("")
        etEmail.setText("")
        etPhone.setText("")
        etAddress.setText("")
        btnDelete.isVisible = false
    }

    private fun isValidationData(): Boolean {
        return etId.text.toString().trim().isNotBlank()
                && etName.text.toString().trim().isNotBlank()
                && etContact.text.toString().trim().isNotBlank()
                && etEmail.text.toString().trim().isNotBlank()
                && etPhone.text.toString().trim().isNotBlank()
    }

    private fun saveProvider() {
        if (isValidationData()) {
            val provider = ProviderViewModel.getProviderById(etId.text.toString().trim())
            if (provider != null && !isEditMode) {
                Toast.makeText(this, getString(R.string.msg_provider_duplicate), Toast.LENGTH_LONG).show()
            } else {
                val newProvider = Provider(
                    etId.text.toString().trim(),
                    etName.text.toString().trim(),
                    etContact.text.toString().trim(),
                    etEmail.text.toString().trim(),
                    etPhone.text.toString().trim(),
                    etAddress.text.toString().trim()
                )

                if (!isEditMode) {
                    ProviderViewModel.saveProvider(newProvider)
                    Toast.makeText(this, getString(R.string.msg_provider_saved), Toast.LENGTH_LONG).show()
                } else {
                    ProviderViewModel.updateProvider(newProvider)
                    Toast.makeText(this, getString(R.string.msg_provider_updated), Toast.LENGTH_LONG).show()
                }

                cleanScreen()
            }
        } else {
            Toast.makeText(this, getString(R.string.msg_required_fields), Toast.LENGTH_LONG).show()
        }
    }

    private fun deleteProvider() {
        ProviderViewModel.removeProvider(etId.text.toString().trim())
        Toast.makeText(this, getString(R.string.msg_provider_deleted), Toast.LENGTH_LONG).show()
        cleanScreen()
    }
}
