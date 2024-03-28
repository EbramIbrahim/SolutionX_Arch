package com.example.solutionxarch.core.android.helpers.logger.writer

import android.util.Log
import com.example.solutionxarch.core.android.helpers.logger.LogWriter
import com.example.solutionxarch.core.android.helpers.logger.file.FileUtil
import com.example.solutionxarch.core.android.helpers.logger.file.LogType
import java.io.File

class FileWriter(
    folderName: String, fileName: String, private val tagKey: String,
    override val isDebugEnabled: Boolean
) : LogWriter {

    override fun debug(clazz: Class<*>, message: String?) {
        if (isDebugEnabled) {
            val formattedMessage = getFormattedMessage(clazz, message)
            Log.d(tagKey, formattedMessage)
            FileUtil.logToFile(LogType.DEBUG, formattedMessage)
        }
    }

    override fun info(clazz: Class<*>, message: String?) {
        if (isDebugEnabled) {
            val formattedMessage = getFormattedMessage(clazz, message)
            Log.i(tagKey, formattedMessage)
            FileUtil.logToFile(LogType.INFO, formattedMessage)
        }
    }

    override fun warning(clazz: Class<*>, message: String?) {
        if (isDebugEnabled) {
            val formattedMessage = getFormattedMessage(clazz, message)
            Log.w(tagKey, formattedMessage)
            FileUtil.logToFile(LogType.WARNING, formattedMessage)
        }
    }

    override fun error(clazz: Class<*>, message: String?, throwable: Throwable?) {
        if (isDebugEnabled) {
            val formattedMessage = getFormattedMessage(clazz, message, throwable)
            Log.e(tagKey, formattedMessage)
            FileUtil.logToFile(LogType.ERROR, formattedMessage)
        }
    }

    private fun getFormattedMessage(
        clazz: Class<*>, message: String?, throwable: Throwable? = null
    ): String {
        return if (throwable == null)
            String.format("[%s] %s", clazz.simpleName, message)
        else
            String.format("[%s] %s %s", clazz.simpleName, message, throwable.toString())
    }

    init {
        if (isDebugEnabled) {
            val logFile: File = FileUtil.checkPermissionsAndCreateFile(folderName, fileName)
            FileUtil.createLogWriter(logFile)
        }
    }
}