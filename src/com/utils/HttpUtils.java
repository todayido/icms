package com.utils;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;

public class HttpUtils
{
  public static Hashtable parseQueryString(String s)
  {
    String[] valArray;
    if (s == null) {
      throw new IllegalArgumentException("queryString must not null");
    }
    Hashtable ht = new Hashtable();
    StringBuffer sb = new StringBuffer();
    StringTokenizer st = new StringTokenizer(s, "&");
    while (st.hasMoreTokens()) {
      String pair = st.nextToken();
      int pos = pair.indexOf('=');
      if (pos == -1) {
        throw new IllegalArgumentException("cannot parse queryString:" + s);
      }
      String key = parseName(pair.substring(0, pos), sb);
      String val = parseName(pair.substring(pos + 1, pair.length()), sb);
      if (ht.containsKey(key)) {
        String[] oldVals = (String[])ht.get(key);
        valArray = new String[oldVals.length + 1];
        for (int i = 0; i < oldVals.length; i++)
          valArray[i] = oldVals[i];
        valArray[oldVals.length] = val;
      } else {
        valArray = new String[1];
        valArray[0] = val;
      }
      ht.put(key, valArray);
    }
    return fixValueArray2SingleStringObject(ht);
  }

  private static Hashtable fixValueArray2SingleStringObject(Hashtable ht)
  {
    Hashtable result = new Hashtable();
    for (Iterator it = ht.entrySet().iterator(); it.hasNext(); ) {
      Map.Entry entry = (Map.Entry)it.next();
      String[] valueArray = (String[])entry.getValue();
      if (valueArray == null)
        result.put(entry.getKey(), valueArray);
      else
        result.put(entry.getKey(), valueArray.length == 1 ? valueArray[0] : valueArray);
    }
    return result;
  }

  private static String parseName(String s, StringBuffer sb) {
    sb.setLength(0);
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      switch (c) {
      case '+':
        sb.append(' ');
        break;
      case '%':
        try {
          sb.append((char)Integer.parseInt(
            s.substring(i + 1, i + 3), 16));
          i += 2;
        }
        catch (NumberFormatException e)
        {
          throw new IllegalArgumentException();
        } catch (StringIndexOutOfBoundsException e) {
          String rest = s.substring(i);
          sb.append(rest);
          if (rest.length() != 2) continue; 
        }
        i++;

        break;
      default:
        sb.append(c);
      }
    }

    return sb.toString();
  }
}