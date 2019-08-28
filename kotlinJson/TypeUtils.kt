package com.iuliao.forecast.vender.kotlinJson

import android.util.Log
import java.math.BigInteger

object TypeUtils {
    private const val TAG = "JSONException"
    fun castToString(value: Any?): String? {
        return value?.toString()
    }

    fun castToChar(value: Any?): Char? {
        if (value == null) {
            return null
        }
        if (value is Char) {
            return value
        }
        if (value is String) {
            val strVal = value as String?
            if (strVal!!.isEmpty()) {
                return null
            }
            if (strVal.length != 1) {
                Log.d(TAG,"can not cast to char, value : $value")
                return null
//                throw JSONException("can not cast to char, value : $value")
            }
            return strVal[0]
        }
        Log.d(TAG,"can not cast to char, value : $value")
        return null
//        throw JSONException("can not cast to char, value : $value")
    }

    fun castToBigInteger(value: Any?): BigInteger? {
        if (value == null) {
            return null
        }
        if (value is BigInteger) {
            return value
        }
        if (value is Float || value is Double) {
            return BigInteger.valueOf((value as Number).toLong())
        }
        val strVal = value.toString()
        return if (strVal.isEmpty() //

                || "null" == strVal //

                || "NULL" == strVal) {
            null
        } else BigInteger(strVal)
    }

    fun castToFloat(value: Any?): Float? {
        if (value == null) {
            return null
        }
        if (value is Number) {
            return value.toFloat()
        }
        if (value is String) {
            var strVal = value.toString()
            if (strVal.isEmpty() //

                    || "null" == strVal //

                    || "NULL" == strVal) {
                return null
            }
            if (strVal.indexOf(',') != 0) {
                strVal = strVal.replace(",".toRegex(), "")
            }
            return try {
                java.lang.Float.parseFloat(strVal)
            } catch (e: Exception) {
                null
            }
        }
        Log.d(TAG,"can not cast to float, value : $value")
        return null
//        throw JSONException("can not cast to float, value : $value")
    }

    fun castToDouble(value: Any?): Double? {
        if (value == null) {
            return null
        }
        if (value is Number) {
            return value.toDouble()
        }
        if (value is String) {
            var strVal = value.toString()
            if (strVal.isEmpty() //

                    || "null" == strVal //

                    || "NULL" == strVal) {
                return null
            }
            if (strVal.indexOf(',') != 0) {
                strVal = strVal.replace(",".toRegex(), "")
            }
            return try {
                java.lang.Double.parseDouble(strVal)
            } catch (e: Exception) {
                null
            }
        }
        Log.d(TAG,"can not cast to double, value : $value")
        return null
//        throw JSONException("can not cast to double, value : $value")
    }

    fun isNumber(str: String): Boolean {
        for (i in 0 until str.length) {
            val ch = str[i]
            if (ch == '+' || ch == '-') {
                if (i != 0) {
                    return false
                }
            } else if (ch < '0' || ch > '9') {
                return false
            }
        }
        return true
    }

    fun castToLong(value: Any?): Long? {
        if (value == null) {
            return null
        }
        if (value is Number) {
            return value.toLong()
        }
        if (value is String) {
            var strVal: String = value
            if (strVal.isEmpty() //

                    || "null" == strVal //

                    || "NULL" == strVal) {
                return null
            }
            if (strVal.indexOf(',') != 0) {
                strVal = strVal.replace(",".toRegex(), "")
            }
            return try {
                strVal.toLong()
            } catch (ex: NumberFormatException) {
                null
            }
        }
        if (value is Map<*, *>) {
            val map = value as Map<*, *>?
            if (map!!.size == 2
                    && map.containsKey("andIncrement")
                    && map.containsKey("andDecrement")) {
                val iter = map.values.iterator()
                iter.next()
                val value2 = iter.next()
                return castToLong(value2)
            }
        }
        Log.d(TAG,"can not cast to long, value : $value")
        return null
//        throw JSONException("can not cast to long, value : $value")
    }

    fun castToInt(value: Any?): Int? {
        if (value == null) {
            return null
        }
        if (value is Int) {
            return value
        }
        if (value is Number) {
            return value.toInt()
        }
        if (value is String) {
            var strVal: String = value
            if (strVal.isEmpty() //

                    || "null" == strVal //

                    || "NULL" == strVal) {
                return null
            }
            if (strVal.indexOf(',') != 0) {
                strVal = strVal.replace(",".toRegex(), "")
            }

            return try {
                Integer.parseInt(strVal)
            } catch (e: Exception) {
                null
            }
        }
        if (value is Boolean) {
            return if (value) 1 else 0
        }
        if (value is Map<*, *>) {
            val map = value as Map<*, *>?
            if (map!!.size == 2
                    && map.containsKey("andIncrement")
                    && map.containsKey("andDecrement")) {
                val iter = map.values.iterator()
                iter.next()
                val value2 = iter.next()
                return castToInt(value2)
            }
        }
        Log.d(TAG,"can not cast to int, value : $value")
        return null
//        throw JSONException("can not cast to int, value : $value")
    }

    fun castToBoolean(value: Any?): Boolean? {
        if (value == null) {
            return null
        }
        if (value is Boolean) {
            return value
        }
        if (value is Number) {
            return value.toInt() == 1
        }
        if (value is String) {
            val strVal = value as String?
            if (strVal!!.isEmpty() //

                    || "null" == strVal //

                    || "NULL" == strVal) {
                return null
            }
            if ("true".equals(strVal, ignoreCase = true) //
                    || "1" == strVal) {
                return java.lang.Boolean.TRUE
            }
            if ("false".equals(strVal, ignoreCase = true) //
                    || "0" == strVal) {
                return java.lang.Boolean.FALSE
            }
            if ("Y".equals(strVal, ignoreCase = true) //
                    || "T" == strVal) {
                return java.lang.Boolean.TRUE
            }
            if ("F".equals(strVal, ignoreCase = true) //
                    || "N" == strVal) {
                return java.lang.Boolean.FALSE
            }
        }
        Log.d(TAG,"can not cast to boolean, value : $value")
        return null
//        throw JSONException("can not cast to boolean, value : $value")
    }

}