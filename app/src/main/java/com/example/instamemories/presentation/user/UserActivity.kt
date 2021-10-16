package com.example.instamemories.presentation.user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.instamemories.R
import com.example.instamemories.data.model.album.AlbumsList
import com.example.instamemories.data.model.user.User
import com.example.instamemories.databinding.ActivityUserBinding
import com.example.instamemories.presentation.di.Injector
import com.example.instamemories.presentation.photo.PhotosActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserBinding
    private lateinit var userViewModel: UserViewModel
    private lateinit var adapter: UserAlbumAdapter
    private val compositeDisposable = CompositeDisposable()
    private val compositeDisposable2 = CompositeDisposable()
    lateinit var user: User
    var userLoaded: Boolean = false

    @Inject
    lateinit var factory: UserViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user)

        (application as Injector).createUserSubComponent().inject(this)

        userViewModel = ViewModelProvider(this, this.factory).get(UserViewModel::class.java)

    }

    override fun onStart() {
        super.onStart()
        compositeDisposable += userViewModel.getUser()!!.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(onSuccess = {
                user = it.get(Math.random().toInt())
                userLoaded = true
                displayUserData(user)
                asyncGetAlbums()
                Log.i("user", it.get(2).toString())
                Log.i("user", user.toString())
            }, onError = {
                Log.i("ERr", it.message.toString())
            })



    }
    private fun asyncGetAlbums(){
        if (userLoaded) {
            compositeDisposable2 += userViewModel.getUserAlbums(user.id)!!
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(onSuccess = {
                    initRecyclerView(it)
                    Log.i("user", it.get(user.id).toString())
                }, onError = {
                    Log.i("ERr", it.message.toString())
                })
        }
    }
    private fun initRecyclerView(albumsList: AlbumsList) {
        binding.albumRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = UserAlbumAdapter(OnClickListener {
            val intent = Intent(this, PhotosActivity::class.java)
            intent.putExtra("albumId", it.id)
            startActivity(intent)
        })
        binding.albumRecyclerView.adapter = adapter
        displayUserAlbumData(albumsList)
    }

    private fun displayUserData(user: User) {
        binding.userName.text = user.name
        binding.userAddr.text =
            user.address.city + " " + user.address.street + " " + user.address.suite
    }

    private fun displayUserAlbumData(albumsList: AlbumsList) {
        if (albumsList != null) {
            adapter.setList(albumsList)
            adapter.notifyDataSetChanged()
        }
    }
}