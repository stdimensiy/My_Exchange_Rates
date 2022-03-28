package ru.vdv.myexchangerates.ui.settings

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import ru.vdv.myexchangerates.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}