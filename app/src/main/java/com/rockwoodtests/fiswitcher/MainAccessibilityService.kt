package com.rockwoodtests.fiswitcher

import android.accessibilityservice.AccessibilityService
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.util.Log
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo
import android.content.Intent
import android.net.Uri


class MainAccessibilityService : AccessibilityService() {
    override fun onInterrupt() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        Log.d("Accessibility Event", event.toString())
        var clipboard = this.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("label", "*#*#342886#*#*")
        clipboard.primaryClip = clip

        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + ""))
        startActivity(intent)
        var theAction = this.rootInActiveWindow as AccessibilityNodeInfo
        theAction.performAction(AccessibilityNodeInfo.ACTION_PASTE)

//        TODO("not implemented")
    }

    fun dialAuto() {
        var clipboard = this.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("label", "*#*#342886#*#*")
        clipboard.primaryClip = clip

        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + ""))
        startActivity(intent)
        var theAction = this.rootInActiveWindow as AccessibilityNodeInfo
        theAction.performAction(AccessibilityNodeInfo.ACTION_PASTE)
    }
}