package com.bandtec.simplify.estudante

import android.R.attr.bitmap
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toIcon
import com.bandtec.simplify.R
import com.bandtec.simplify.conexaoApiEstudante.ConexaoEstudanteApi
import com.bandtec.simplify.conexaoApiEstudante.EstudanteDocumeto
import kotlinx.android.synthetic.main.activity_estudante_envio_documentos.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.nio.ByteBuffer


class EstudanteEnvioDocumentos : AppCompatActivity() {

    val REQUEST_IMAGE_CAPTURE = 1
    lateinit var ImageViewFoto : ImageView
    lateinit var checkBoxUpload: CheckBox

    lateinit var imageBitmap: Bitmap


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estudante_envio_documentos)

        val mySpinner : Spinner = findViewById(R.id.spinner_documents_pending)

        ImageViewFoto = findViewById(R.id.imageViewFoto)
        checkBoxUpload = findViewById(R.id.checkBox)

        ArrayAdapter.createFromResource(
            this,
            R.array.documentos,
            android.R.layout.simple_spinner_item
        ).also{ adapter -> adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            mySpinner.adapter = adapter
        }
    }

    fun selectImage(view: View){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Upload Simplify")
        builder.setMessage("Você deseja fazer o upload do documento")
        builder.setPositiveButton("Abrir Camera"){ dialog, wich ->
            openCamera()
            // Toast.makeText(this, "Você selecionou a cam", Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("Abrir Galeria"){ dialog, wich ->
            openGallery()
           // Toast.makeText(this, "Você selecionou a galeria", Toast.LENGTH_SHORT).show()
        }
        builder.setNeutralButton("Cancelar"){ _, _ ->
            onBackPressed()
        }
        val dialog: AlertDialog= builder.create()
        dialog.show()
    }

    fun openCamera(){
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }
    }

    fun openGallery(){
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            imageBitmap = data?.extras?.get("data") as Bitmap
            imageViewFoto.setImageBitmap(imageBitmap)
        }
    }

    fun createPostDoc(view: View){
        var estudanteDocumento: EstudanteDocumeto = EstudanteDocumeto("teste", imageBitmap)

        if(!checkBoxUpload.isChecked){
            Toast.makeText(this, "Por favor, concorde com os termos", Toast.LENGTH_SHORT).show()
        }else{

            val byteBuffer: ByteBuffer = ByteBuffer.allocate(estudanteDocumento.documento.getByteCount())
            estudanteDocumento.documento.copyPixelsToBuffer(byteBuffer)
            byteBuffer.rewind()
            val bytesImagem = byteBuffer.array()


            val requisicaoImagem: MultipartBody.Part = MultipartBody.Part.createFormData("file", "foto.png", RequestBody.create(
                MediaType.parse("image/*"), bytesImagem))

            ConexaoEstudanteApi.criar().uploadImage(requisicaoImagem)

                .enqueue(object : Callback<Void> {
                    override fun onResponse(call: Call<Void>, response: Response<Void>) {
                        val statusResponse = response

                        if (statusResponse.code() == 200) {
                            startActivity(
                                Intent(
                                    this@EstudanteEnvioDocumentos,
                                    ConsultaEstudante::class.java
                                )
                            )
                        }
                    }

                    override fun onFailure(call: Call<Void>, t: Throwable) {
                        print(t)
                        val builder = AlertDialog.Builder(this@EstudanteEnvioDocumentos)
                        builder.setTitle("Erro")
                        builder.setMessage(t.toString())
                        val dialog: AlertDialog = builder.create()
                        dialog.show()

                        Toast.makeText(
                            this@EstudanteEnvioDocumentos,
                            "Ocorreu um erro com o servidor,\ntente novamente mais tarde",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                })
        }
    }

    fun back(view: View) { onBackPressed() }


}