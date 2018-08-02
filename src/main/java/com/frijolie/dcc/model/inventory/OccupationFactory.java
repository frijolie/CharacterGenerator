package com.frijolie.dcc.model.inventory;

import com.frijolie.dcc.io.OccupationSerializer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

public class OccupationFactory {

  private static List<Occupation> occupationList;
  private static Map<Integer, Occupation> occupationByIndex;

  static {
    occupationList = new ArrayList<>(new OccupationSerializer().getOccupationList());
    occupationByIndex = new HashMap<>();
    occupationByIndex.put(1, occupationList.get(0));
    occupationByIndex.put(2, occupationList.get(1));
    occupationByIndex.put(3, occupationList.get(2));
    occupationByIndex.put(4, occupationList.get(3));
    occupationByIndex.put(5, occupationList.get(4));
    occupationByIndex.put(6, occupationList.get(5));
    occupationByIndex.put(7, occupationList.get(6));
    occupationByIndex.put(8, occupationList.get(7));
    occupationByIndex.put(9, occupationList.get(8));
    occupationByIndex.put(10, occupationList.get(9));
    occupationByIndex.put(11, occupationList.get(10));
    occupationByIndex.put(12, occupationList.get(11));
    occupationByIndex.put(13, occupationList.get(12));
    occupationByIndex.put(14, occupationList.get(13));
    occupationByIndex.put(15, occupationList.get(14));
    occupationByIndex.put(16, occupationList.get(15));
    occupationByIndex.put(17, occupationList.get(16));
    occupationByIndex.put(18, occupationList.get(17));
    occupationByIndex.put(19, occupationList.get(18));
    occupationByIndex.put(20, occupationList.get(19));
    occupationByIndex.put(21, occupationList.get(20));
    occupationByIndex.put(22, occupationList.get(21));
    occupationByIndex.put(23, occupationList.get(22));
    occupationByIndex.put(24, occupationList.get(22));
    occupationByIndex.put(25, occupationList.get(23));
    occupationByIndex.put(26, occupationList.get(24));
    occupationByIndex.put(27, occupationList.get(25));
    occupationByIndex.put(28, occupationList.get(25));
    occupationByIndex.put(29, occupationList.get(26));
    occupationByIndex.put(30, occupationList.get(27));
    occupationByIndex.put(31, occupationList.get(28));
    occupationByIndex.put(32, occupationList.get(29));
    occupationByIndex.put(33, occupationList.get(30));
    occupationByIndex.put(34, occupationList.get(30));
    occupationByIndex.put(35, occupationList.get(31));
    occupationByIndex.put(36, occupationList.get(32));
    occupationByIndex.put(37, occupationList.get(33));
    occupationByIndex.put(38, occupationList.get(33));
    occupationByIndex.put(39, occupationList.get(34));
    occupationByIndex.put(40, occupationList.get(34));
    occupationByIndex.put(41, occupationList.get(34));
    occupationByIndex.put(42, occupationList.get(34));
    occupationByIndex.put(43, occupationList.get(34));
    occupationByIndex.put(44, occupationList.get(34));
    occupationByIndex.put(45, occupationList.get(34));
    occupationByIndex.put(46, occupationList.get(34));
    occupationByIndex.put(47, occupationList.get(34));
    occupationByIndex.put(48, occupationList.get(35));
    occupationByIndex.put(49, occupationList.get(36));
    occupationByIndex.put(50, occupationList.get(37));
    occupationByIndex.put(51, occupationList.get(38));
    occupationByIndex.put(52, occupationList.get(38));
    occupationByIndex.put(53, occupationList.get(39));
    occupationByIndex.put(54, occupationList.get(39));
    occupationByIndex.put(55, occupationList.get(40));
    occupationByIndex.put(56, occupationList.get(41));
    occupationByIndex.put(57, occupationList.get(41));
    occupationByIndex.put(58, occupationList.get(42));
    occupationByIndex.put(59, occupationList.get(43));
    occupationByIndex.put(60, occupationList.get(44));
    occupationByIndex.put(61, occupationList.get(45));
    occupationByIndex.put(62, occupationList.get(46));
    occupationByIndex.put(63, occupationList.get(47));
    occupationByIndex.put(64, occupationList.get(48));
    occupationByIndex.put(65, occupationList.get(49));
    occupationByIndex.put(66, occupationList.get(50));
    occupationByIndex.put(67, occupationList.get(51));
    occupationByIndex.put(68, occupationList.get(52));
    occupationByIndex.put(69, occupationList.get(52));
    occupationByIndex.put(70, occupationList.get(53));
    occupationByIndex.put(71, occupationList.get(54));
    occupationByIndex.put(72, occupationList.get(55));
    occupationByIndex.put(73, occupationList.get(56));
    occupationByIndex.put(74, occupationList.get(57));
    occupationByIndex.put(75, occupationList.get(58));
    occupationByIndex.put(76, occupationList.get(59));
    occupationByIndex.put(77, occupationList.get(60));
    occupationByIndex.put(78, occupationList.get(61));
    occupationByIndex.put(79, occupationList.get(62));
    occupationByIndex.put(80, occupationList.get(63));
    occupationByIndex.put(81, occupationList.get(64));
    occupationByIndex.put(82, occupationList.get(65));
    occupationByIndex.put(83, occupationList.get(66));
    occupationByIndex.put(84, occupationList.get(67));
    occupationByIndex.put(85, occupationList.get(68));
    occupationByIndex.put(86, occupationList.get(69));
    occupationByIndex.put(87, occupationList.get(70));
    occupationByIndex.put(88, occupationList.get(71));
    occupationByIndex.put(89, occupationList.get(72));
    occupationByIndex.put(90, occupationList.get(72));
    occupationByIndex.put(91, occupationList.get(73));
    occupationByIndex.put(92, occupationList.get(74));
    occupationByIndex.put(93, occupationList.get(74));
    occupationByIndex.put(94, occupationList.get(75));
    occupationByIndex.put(95, occupationList.get(76));
    occupationByIndex.put(96, occupationList.get(77));
    occupationByIndex.put(97, occupationList.get(78));
    occupationByIndex.put(98, occupationList.get(79));
    occupationByIndex.put(99, occupationList.get(79));
    occupationByIndex.put(100, occupationList.get(79));
  }

  public static Occupation getByIndex(int index) {
    if (occupationByIndex.containsKey(index)) {
      try {
        return occupationByIndex.get(index).clone();
      } catch (CloneNotSupportedException e) {
        e.printStackTrace();
      }
    } else {
      throw new NoSuchElementException(index +
          " is not a valid index in occupationByIndex. Cannot return the occupation");
    }
    return null;
  }
}