package org.kotlin.preacher.jok3r.ui.jokes


import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.kotlin.preacher.jok3r.R
import org.kotlin.preacher.jok3r.utils.isOnline
import org.kotlin.preacher.jok3r.viewmodels.JokesViewModel

class JokesFragment : Fragment() {

    private val jokesViewModel: JokesViewModel by viewModel()

    private lateinit var jokeTextView: TextView
    private lateinit var getJokeButton: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_jokes, container, false)
        initViews(view)
        setHasOptionsMenu(true)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        observeErrorStatus()
        observeJokeContent()
        observeLoadingStatus()
    }

    private fun initViews(view: View) {
        with(view) {
            jokeTextView = findViewById(R.id.joke_text_view)
            getJokeButton = findViewById<Button>(R.id.get_joke_button).apply {
                setOnClickListener { getJoke() }
            }
        }
    }

    private fun getJoke() {
        if (isOnline(context!!))
            jokesViewModel.getJoke()
        else
            Toast.makeText(context,getString(R.string.error_internet_connection),Toast.LENGTH_SHORT).show()
    }

    private fun observeErrorStatus() {
        jokesViewModel.errorResponse.observe(this) { errorMessage ->
            Snackbar.make(getJokeButton, errorMessage, Snackbar.LENGTH_LONG).show()
            jokeTextView.text = getString(R.string.info_no_joke_loaded)
            jokeTextView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_sad, 0, 0)

        }
    }

    private fun observeJokeContent() {
        jokesViewModel.jokeContent.observe(this) { joke ->
            jokeTextView.text = joke
            jokeTextView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_happy, 0, 0)
        }
    }

    private fun observeLoadingStatus() {
        jokesViewModel.isLoading.observe(this) {
            //TODO Add Progress Bar
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
}

