package com.yquery.gdscnavigationdrawer

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.yquery.gdscnavigationdrawer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setTheme(R.style.Theme_GDSCNavigationDrawer_NoActionBar)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        binding.appBarMain.fab.setOnClickListener { view ->
            Snackbar.make(view, "About app ?", Snackbar.LENGTH_LONG)
                .setAction("About") {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("About App")
                        .setMessage("I know that this functionality is not allowed in a real app , but this is not a real one.")
                        .setPositiveButton("Ok", DialogInterface.OnClickListener { dialog, which ->
                            dialog.dismiss()
                        })
                        .setIcon(R.drawable.ic_round_info)
                        .show()
                }.show()
        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_main) as NavHostFragment
        val navController = navHostFragment.navController
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_test_one, R.id.nav_test_two
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        navView.setNavigationItemSelectedListener { menuItem ->
            // Handle menu item selected
            when (menuItem.itemId) {
                R.id.nav_test_one -> {
                    navController.navigate(R.id.nav_test_one)
                }
                R.id.nav_home -> {
                    navController.navigate(R.id.nav_home)
                }
                R.id.nav_test_two -> {
                    navController.navigate(R.id.nav_test_two)
                }
                R.id.nav_dev_profile -> {
                    val devLinkIntent = Intent(Intent.ACTION_VIEW)
                    devLinkIntent.data =
                        Uri.parse("https://play.google.com/store/apps/dev?id=6245006738668751785")
                    startActivity(devLinkIntent)
                }
                R.id.nav_share -> {
                    val shareAppIntent = Intent()
                    shareAppIntent.apply {
                        action = Intent.ACTION_SEND
                        putExtra(
                            Intent.EXTRA_TEXT,
                            "Just Sharing !"
                        )
                        putExtra(Intent.EXTRA_TITLE, "Share App")
                        type = "text/plain"
                    }

                    val shareIntentChooser = Intent.createChooser(shareAppIntent, null)
                    startActivity(shareIntentChooser)
                }
            }
            drawerLayout.close()
            true
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

}