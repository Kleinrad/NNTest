/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nntest.tagImages;

import java.io.File;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import nntest.NameInfo;

/**
 *
 * @author fabia
 */
public class GetImageMap {

    public static TreeMap<Integer, Integer[]> getResultMap(String folderPath) {
        TreeMap<Integer, Integer[]> map = new TreeMap<Integer, Integer[]>();
        Pattern abmTest = Pattern.compile("Abm.");
        Pattern aliyTest = Pattern.compile("Al(i|y).");
        Pattern besTest = Pattern.compile("Bes(A|H).");
        Pattern hamTest = Pattern.compile("(HamA|H(eb|ad).)");

        File[] imageFiles = new File(folderPath).listFiles();
        for (int i = 0; i < imageFiles.length; i++) {
            File img = imageFiles[i];
           
            NameInfo imgInfo = nntest.NetworkUntils.getImageNameInfo(img.getName());
            Matcher nameAbmMatcher = abmTest.matcher(imgInfo.name);
            Matcher nameAliyMatcher = aliyTest.matcher(imgInfo.name);
            Matcher nameBesMatcher = besTest.matcher(imgInfo.name);
            Matcher nameHamMatcher = hamTest.matcher(imgInfo.name);
            try {
                if (imgInfo.name.equals("AbdA")) {
                    Integer[] faceLocation = getFaceLocation(i, i, i, i); // 
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if (imgInfo.name.equals("AbdH")) {
                    Integer[] faceLocation = setAdbH(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if (imgInfo.name.equals("AheG") || imgInfo.name.equals("AheS")) {
                    Integer[] faceLocation = setAheGtoAheS(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if (nameAbmMatcher.matches()) {
                    Integer[] faceLocation = setAhm_(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if (imgInfo.name.equals("AlaG")) {
                    Integer[] faceLocation = getFaceLocation(198, 9, 376, 225);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if (nameAliyMatcher.matches()) {
                    Integer[] faceLocation = setAliy_(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if (imgInfo.name.equals("AndM")) {
                    Integer[] faceLocation = setAndM(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if (imgInfo.name.equals("AndP")) {
                    Integer[] faceLocation = setAndP(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if (imgInfo.name.equals("AshS") || imgInfo.name.equals("AsmH")) {
                    Integer[] faceLocation = setAshSAsmH(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if (imgInfo.name.equals("AymK")) {
                    Integer[] faceLocation = setAymK(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if (imgInfo.name.equals("BahA")) {
                    Integer[] faceLocation = setBahA(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if (imgInfo.name.equals("BelA")) {
                    Integer[] faceLocation = setBelA(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if(nameBesMatcher.matches()){
                    Integer[] faceLocation = setBes(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if (imgInfo.name.equals("BonG")) {
                    Integer[] faceLocation = setBonG(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if (imgInfo.name.equals("DoaB")) {
                    Integer[] faceLocation = setDoaB(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if (imgInfo.name.equals("EbrK") || imgInfo.name.equals("GamS") ||imgInfo.name.equals("Gawl")) {
                    Integer[] faceLocation = setErbKGamSGawl(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if (imgInfo.name.equals("GeoS") || imgInfo.name.equals("GhaN")) {
                    Integer[] faceLocation = setGeoSGhaN(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if (nameHamMatcher.matches()){
                    Integer[] faceLocation = setHad(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if (imgInfo.name.equals("HitE")) {
                    Integer[] faceLocation = setHitE(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if (imgInfo.name.equals("HitS") || imgInfo.name.equals("HosG") || imgInfo.name.equals("IbrM") 
                        || imgInfo.name.equals("IslK") || imgInfo.name.equals("JakN")) {
                    Integer[] faceLocation = setHbisJ(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if (imgInfo.name.equals("KarH")) {
                    Integer[] faceLocation = setKarH(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if (imgInfo.name.equals("KhaS")) {
                    Integer[] faceLocation = setKhaS(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if (imgInfo.name.equals("LalG")) {
                    Integer[] faceLocation = setLalG(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if (imgInfo.name.equals("MahA")) {
                    Integer[] faceLocation = setMahA(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if (imgInfo.name.equals("MahM")) {
                    Integer[] faceLocation = setMahM(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if (imgInfo.name.equals("MahS") || imgInfo.name.equals("MalA") || imgInfo.name.equals("MarE") 
                        || imgInfo.name.equals("MarG") || imgInfo.name.equals("MarH") || imgInfo.name.equals("MarM")
                        || imgInfo.name.equals("MarR") || imgInfo.name.equals("MarS") || imgInfo.name.equals("MayA")) {
                    Integer[] faceLocation = setMahSlArErGrHrMrRrSyA(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if (imgInfo.name.equals("MazR")) {
                    Integer[] faceLocation = setMazR(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }               
                if (imgInfo.name.equals("MeiH") || imgInfo.name.equals("MerB") || imgInfo.name.equals("MerD")) {
                    Integer[] faceLocation = setMeiHMerBMerD(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if (imgInfo.name.equals("MerK")) {
                    Integer[] faceLocation = setMerK(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }    
                if (imgInfo.name.equals("MerM")) {
                    Integer[] faceLocation = setMerM(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }    
                if (imgInfo.name.equals("MerN")) {
                    Integer[] faceLocation = setMerN(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }    
                if (imgInfo.name.equals("MhmA") || imgInfo.name.equals("MirM")) {
                    Integer[] faceLocation = setMhmAMirM(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                } 
                if (imgInfo.name.equals("MirT") || imgInfo.name.equals("MnyA") || imgInfo.name.equals("MohA") || imgInfo.name.equals("MohB")
                        || imgInfo.name.equals("MohF")) {
                    Integer[] faceLocation = setMirTMnyAMohABF(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }  
                if (imgInfo.name.equals("MohG")) {
                    Integer[] faceLocation = setMohG(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if (imgInfo.name.equals("MohH")) {
                    Integer[] faceLocation = setMohH(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if (imgInfo.name.equals("MohN")) {
                    Integer[] faceLocation = setMohN(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if (imgInfo.name.equals("MonD")) {
                    Integer[] faceLocation = setMonD(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if (imgInfo.name.equals("MonM") || imgInfo.name.equals("MosB") || imgInfo.name.equals("MosK")) {
                    Integer[] faceLocation = setMonMMosBMosK(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if (imgInfo.name.equals("MotM")) {
                    Integer[] faceLocation = setMotM(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if (imgInfo.name.equals("MriE") || imgInfo.name.equals("MyrM")) {
                    Integer[] faceLocation = setMirEMyrM(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if (imgInfo.name.equals("NahA")) {
                    Integer[] faceLocation = setNahA(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                
                if (imgInfo.name.equals("NasA")) {
                    Integer[] faceLocation = setNasA(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if (imgInfo.name.equals("NasH") || imgInfo.name.equals("NerF")) {
                    Integer[] faceLocation = setNasHNerF(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if (imgInfo.name.equals("NohS") || imgInfo.name.equals("NorA")) {
                    Integer[] faceLocation = setNohSNorA(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if (imgInfo.name.equals("OliA")) {
                    Integer[] faceLocation = setOliA(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if (imgInfo.name.equals("OmaK")) {
                    Integer[] faceLocation = setOmaK(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if (imgInfo.name.equals("PetB")) {
                    Integer[] faceLocation = setPetB(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if (imgInfo.name.equals("PetJ")) {
                    Integer[] faceLocation = setPetJ(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if (imgInfo.name.equals("PetK")) {
                    Integer[] faceLocation = setPetK(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if (imgInfo.name.equals("PetN")) {
                    Integer[] faceLocation = setPetN(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if (imgInfo.name.equals("ReeS")) {
                    Integer[] faceLocation = setReeS(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if (imgInfo.name.equals("RehM") || imgInfo.name.equals("RimA")) {
                    Integer[] faceLocation = setRehMRimA(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if (imgInfo.name.equals("SarA")) {
                    Integer[] faceLocation = setSarA(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if (imgInfo.name.equals("SarE")) {
                    Integer[] faceLocation = setSarE(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if (imgInfo.name.equals("SarM")) {
                    Integer[] faceLocation = setSarM(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if (imgInfo.name.equals("SarN") || imgInfo.name.equals("SarS")) {
                    Integer[] faceLocation = setSarNSarS(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if (imgInfo.name.equals("ShrM") || imgInfo.name.equals("SraE")) {
                    Integer[] faceLocation = setShrM(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if (imgInfo.name.equals("YehK")) {
                    Integer[] faceLocation = setYehK(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if (imgInfo.name.equals("YosA")) {
                    Integer[] faceLocation = setYosA(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if (imgInfo.name.equals("YosB")) {
                    Integer[] faceLocation = setYosB(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if (imgInfo.name.equals("YouA")) {
                    Integer[] faceLocation = setYouA(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if (imgInfo.name.equals("YouR")) {
                    Integer[] faceLocation = setYouR(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                if (imgInfo.name.equals("ZenH")) {
                    Integer[] faceLocation = setZenH(imgInfo);
                    map.put(getHash(imgInfo), faceLocation);
                    continue;
                }
                
            } catch (Exception e) {
                System.out.println(imgInfo.number);
            }
        }

        return map;
    }

    private static int getHash(NameInfo imgInfo){
        return imgInfo.number.hashCode() + imgInfo.name.hashCode();
    }
    
    private static Integer[] setZenH(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if(num == 2657){
            faceLocation = getFaceLocation(133, 91, 340, 353);
            return faceLocation;
        }
        if(num == 2658){
            faceLocation = getFaceLocation(113, 84, 302, 320);
            return faceLocation;
        }
        if(num == 2659){
            faceLocation = getFaceLocation(138, 70, 309, 313);
            return faceLocation;
        }
        if(num == 2660){
            faceLocation = getFaceLocation(310, 113, 434, 279);
            return faceLocation;
        }
        if(num == 2661){
            faceLocation = getFaceLocation(241, 87, 395, 282);
            return faceLocation;
        }
        if(num == 2662){
            faceLocation = getFaceLocation(290, 327, 366, 414);
            return faceLocation;
        }

        throw new Exception("tagging");
    }
    
    private static Integer[] setYouR(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if(num == 2651){
            faceLocation = getFaceLocation(178, 72, 431, 442);
            return faceLocation;
        }
        if(num == 2652){
            faceLocation = getFaceLocation(198, 52, 410, 398);
            return faceLocation;
        }
        if(num == 2653){
            faceLocation = getFaceLocation(273, 204, 387, 367);
            return faceLocation;
        }
        if(num == 2654){
            faceLocation = getFaceLocation(242, 75, 583, 428);
            return faceLocation;
        }
        if(num == 2655){
            faceLocation = getFaceLocation(367, 53, 530, 283);
            return faceLocation;
        }
        if(num == 2656){
            faceLocation = getFaceLocation(209, 98, 449, 357);
            return faceLocation;
        }

        throw new Exception("tagging");
    }
    
    private static Integer[] setYouA(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if(num == 2646){
            faceLocation = getFaceLocation(111, 58, 367, 398);
            return faceLocation;
        }
        if(num == 2647){
            faceLocation = getFaceLocation(62, 106, 283, 380);
            return faceLocation;
        }
        if(num == 2648){
            faceLocation = getFaceLocation(357, 131, 510, 321);
            return faceLocation;
        }
        if(num == 2649){
            faceLocation = getFaceLocation(284, 147, 506, 415);
            return faceLocation;
        }
        if(num == 2650){
            faceLocation = getFaceLocation(111, 46, 283, 279);
            return faceLocation;
        }

        throw new Exception("tagging");
    }
    
    private static Integer[] setYosB(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if(num == 2460){
            faceLocation = getFaceLocation(238, 30, 463, 305);
            return faceLocation;
        }
        if(num == 2461){
            faceLocation = getFaceLocation(258, 49, 454, 286);
            return faceLocation;
        }
        if(num == 2462){
            faceLocation = getFaceLocation(225, 44, 429, 302);
            return faceLocation;
        }
        if(num == 2463){
            faceLocation = getFaceLocation(204, 54, 399, 279);
            return faceLocation;
        }
        if(num == 2464){
            faceLocation = getFaceLocation(260, 179, 377, 329);
            return faceLocation;
        }
        if(num == 2465){
            faceLocation = getFaceLocation(277, 176, 389, 326);
            return faceLocation;
        }
        if(num >= 2466 && num <= 2469){
            faceLocation = getFaceLocation(281, 180, 392, 320);
            return faceLocation;
        }
        if(num >= 2470 && num <= 2472){
            faceLocation = getFaceLocation(322, 171, 433, 320);
            return faceLocation;
        }
        if(num >= 2473 && num <= 2479){
            faceLocation = getFaceLocation(376, 180, 486, 327);
            return faceLocation;
        }
        if(num >= 2480 && num <= 2489){
            faceLocation = getFaceLocation(363, 156, 481, 309);
            return faceLocation;
        }
        if(num >= 2490 && num <= 2495){
            faceLocation = getFaceLocation(347, 156, 473, 309);
            return faceLocation;
        }
        if(num >= 2496 && num <= 2499){
            faceLocation = getFaceLocation(346, 163, 472, 310);
            return faceLocation;
        }
        if(num >= 2500 && num <= 2509){
            faceLocation = getFaceLocation(344, 166, 463, 305);
            return faceLocation;
        }
        if(num >= 2510 && num <= 2519){
            faceLocation = getFaceLocation(356, 157, 482, 301);
            return faceLocation;
        }
        if(num >= 2520 && num <= 2526){
            faceLocation = getFaceLocation(368, 165, 485, 312);
            return faceLocation;
        }
        if(num >= 2527  && num <= 2539){
            faceLocation = getFaceLocation(371, 158, 493, 307);
            return faceLocation;
        }
        if(num >= 2540  && num <= 2549){
            faceLocation = getFaceLocation(370, 158, 486, 313);
            return faceLocation;
        }
        if(num >= 2550  && num <= 2559){
            faceLocation = getFaceLocation(365, 162, 481, 314);
            return faceLocation;
        }
        if(num >= 2560  && num <= 2569){
            faceLocation = getFaceLocation(384, 160, 502, 318);
            return faceLocation;
        }
        if(num >= 2570  && num <= 2579){
            faceLocation = getFaceLocation(363, 159, 474, 311);
            return faceLocation;
        }
        if(num >= 2580  && num <= 2589){
            faceLocation = getFaceLocation(363, 159, 478, 309);
            return faceLocation;
        }
        if(num >= 2590  && num <= 2599){
            faceLocation = getFaceLocation(352, 158, 479, 321);
            return faceLocation;
        }
        if(num >= 2600  && num <= 2609){
            faceLocation = getFaceLocation(365, 158, 475, 306);
            return faceLocation;
        }
        if(num >= 2610 && num <= 2619){
            faceLocation = getFaceLocation(365, 159, 478, 310);
            return faceLocation;
        }
        if(num >= 2620 && num <= 2629){
            faceLocation = getFaceLocation(361, 161, 477, 309);
            return faceLocation;
        }
        if(num >= 2630 && num <= 2639){
            faceLocation = getFaceLocation(328, 171, 457, 335);
            return faceLocation;
        }
        if(num >= 2640 && num <= 2644){
            faceLocation = getFaceLocation(363, 154, 480, 305);
            return faceLocation;
        }
        if(num == 2645){
            faceLocation = getFaceLocation(352, 156, 470, 303);
            return faceLocation;
        }

        throw new Exception("tagging");
    }
    
    private static Integer[] setYosA(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if(num == 2452){
            faceLocation = getFaceLocation(194, 66, 359, 257);
            return faceLocation;
        }
        if(num == 2453){
            faceLocation = getFaceLocation(185, 85, 396, 333);
            return faceLocation;
        }
        if(num == 2454){
            faceLocation = getFaceLocation(193, 85, 409, 331);
            return faceLocation;
        }
        if(num == 2455){
            faceLocation = getFaceLocation(288, 64, 498, 330);
            return faceLocation;
        }
        if(num == 2456){
            faceLocation = getFaceLocation(220, 103, 485, 416);
            return faceLocation;
        }
        if(num == 2457){
            faceLocation = getFaceLocation(174, 101, 414, 367);
            return faceLocation;
        }
        if(num == 2458){
            faceLocation = getFaceLocation(224, 76, 464, 351);
            return faceLocation;
        }
        if(num == 2459){
            faceLocation = getFaceLocation(206, 139, 451, 416);
            return faceLocation;
        }

        throw new Exception("tagging");
    }
    
    private static Integer[] setYehK(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if(num == 2447){
            faceLocation = getFaceLocation(163, 72, 391, 380);
            return faceLocation;
        }
        if(num == 2448){
            faceLocation = getFaceLocation(88, 95, 276, 347);
            return faceLocation;
        }
        if(num == 2449){
            faceLocation = getFaceLocation(37, 85, 292, 440);
            return faceLocation;
        }
        if(num == 2450){
            faceLocation = getFaceLocation(98, 52, 331, 394);
            return faceLocation;
        }
        if(num == 2451){
            faceLocation = getFaceLocation(81, 89, 312, 421);
            return faceLocation;
        }

        throw new Exception("tagging");
    }
    
    private static Integer[] setShrM(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if(num == 2442){
            faceLocation = getFaceLocation(62, 84, 346, 455);
            return faceLocation;
        }
        if(num == 2443){
            faceLocation = getFaceLocation(66, 108, 292, 403);
            return faceLocation;
        }
        if(num == 2444){
            faceLocation = getFaceLocation(266, 81, 451, 313);
            return faceLocation;
        }
        if(num == 2445){
            faceLocation = getFaceLocation(135, 88, 399, 444);
            return faceLocation;
        }
        if(num == 2446){
            faceLocation = getFaceLocation(80, 155, 222, 323);
            return faceLocation;
        }

        throw new Exception("tagging");
    }
    
    private static Integer[] setSarNSarS(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if(num == 2432){
            faceLocation = getFaceLocation(246, 58, 433, 288);
            return faceLocation;
        }
        if(num == 2433){
            faceLocation = getFaceLocation(221, 73, 405, 291);
            return faceLocation;
        }
        if(num == 2434){
            faceLocation = getFaceLocation(244, 79, 421, 284);
            return faceLocation;
        }
        if(num == 2435){
            faceLocation = getFaceLocation(236, 109, 441, 356);
            return faceLocation;
        }
        if(num == 2436){
            faceLocation = getFaceLocation(474, 190, 573, 321);
            return faceLocation;
        }
        if(num == 2437){
            faceLocation = getFaceLocation(343, 142, 565, 423);
            return faceLocation;
        }
        if(num == 2438){
            faceLocation = getFaceLocation(383, 105, 602, 387);
            return faceLocation;
        }
        if(num == 2439){
            faceLocation = getFaceLocation(35, 101, 245, 381);
            return faceLocation;
        }
        if(num == 2440){
            faceLocation = getFaceLocation(52, 147, 256, 402);
            return faceLocation;
        }
        if(num == 2441){
            faceLocation = getFaceLocation(80, 93, 390, 459);
            return faceLocation;
        }

        throw new Exception("tagging");
    }
    
    private static Integer[] setSarM(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if(num == 2424){
            faceLocation = getFaceLocation(163, 109, 395, 381);
            return faceLocation;
        }
        if(num == 2425){
            faceLocation = getFaceLocation(99, 87, 314, 358);
            return faceLocation;
        }
        if(num == 2426){
            faceLocation = getFaceLocation(218, 101, 442, 383);
            return faceLocation;
        }
        if(num == 2427){
            faceLocation = getFaceLocation(209, 90, 474, 406);
            return faceLocation;
        }
        if(num == 2428){
            faceLocation = getFaceLocation(209, 124, 472, 422);
            return faceLocation;
        }
        if(num == 2429){
            faceLocation = getFaceLocation(187, 114, 421, 387);
            return faceLocation;
        }
        if(num == 2430){
            faceLocation = getFaceLocation(156, 100, 401, 405);
            return faceLocation;
        }
        if(num == 2431){
            faceLocation = getFaceLocation(184, 87, 425, 370);
            return faceLocation;
        }

        throw new Exception("tagging");
    }
    
    private static Integer[] setSarE(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if(num == 2315){
            faceLocation = getFaceLocation(21, 3, 429, 473);
            return faceLocation;
        }
        if(num == 2316){
            faceLocation = getFaceLocation(108, 93, 279, 342);
            return faceLocation;
        }
        if(num == 2317){
            faceLocation = getFaceLocation(69, 96, 255, 369);
            return faceLocation;
        }
        if(num == 2318){
            faceLocation = getFaceLocation(128, 90, 291, 320);
            return faceLocation;
        }
        if(num == 2319){
            faceLocation = getFaceLocation(124, 98, 285, 334);
            return faceLocation;
        }
        if(num >= 2320 && num <= 2326){
            faceLocation = getFaceLocation(226, 112, 355, 280);
            return faceLocation;
        }
        if(num >= 2327 && num <= 2329){
            faceLocation = getFaceLocation(229, 118, 350, 274);
            return faceLocation;
        }
        if(num >= 2330 && num <= 2339){
            faceLocation = getFaceLocation(211, 114, 342, 275);
            return faceLocation;
        }
        if(num >= 2340 && num <= 2343){
            faceLocation = getFaceLocation(227, 117, 349, 272);
            return faceLocation;
        }
        if(num >= 2344 && num <= 2349){
            faceLocation = getFaceLocation(237, 113, 362, 280);
            return faceLocation;
        }
        if(num >= 2350 && num <= 2359){
            faceLocation = getFaceLocation(242, 109, 356, 259);
            return faceLocation;
        }
        if(num >= 2360 && num <= 2371){
            faceLocation = getFaceLocation(223, 112, 339, 264);
            return faceLocation;
        }
        if(num >= 2372 && num <= 2379){
            faceLocation = getFaceLocation(225, 110, 347, 269);
            return faceLocation;
        }
        if(num >= 2380 && num <= 2389){
            faceLocation = getFaceLocation(250, 120, 371, 279);
            return faceLocation;
        }
        if(num >= 2390 && num <= 2399){
            faceLocation = getFaceLocation(239, 103, 354, 259);
            return faceLocation;
        }
        if(num >= 2400 && num <= 2409){
            faceLocation = getFaceLocation(233, 106, 363, 266);
            return faceLocation;
        }
        if(num >= 2410 && num <= 2421){
            faceLocation = getFaceLocation(244, 109, 366, 269);
            return faceLocation;
        }
        if(num == 2422){
            faceLocation = getFaceLocation(245, 109, 361, 264);
            return faceLocation;
        }
        if(num == 2423){
            faceLocation = getFaceLocation(178, 4, 499, 451);
            return faceLocation;
        }

        throw new Exception("tagging");
    }
    
    private static Integer[] setSarA(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if(num == 2307){
            faceLocation = getFaceLocation(254, 90, 434, 318);
            return faceLocation;
        }
        if(num == 2308){
            faceLocation = getFaceLocation(182, 104, 371, 323);
            return faceLocation;
        }
        if(num == 2309){
            faceLocation = getFaceLocation(252, 116, 438, 354);
            return faceLocation;
        }
        if(num == 2310){
            faceLocation = getFaceLocation(186, 87, 361, 304);
            return faceLocation;
        }
        if(num == 2311){
            faceLocation = getFaceLocation(169, 116, 372, 373);
            return faceLocation;
        }
        if(num == 2312){
            faceLocation = getFaceLocation(294, 80, 490, 328);
            return faceLocation;
        }
        if(num == 2313){
            faceLocation = getFaceLocation(209, 84, 395, 329);
            return faceLocation;
        }
        if(num == 2314){
            faceLocation = getFaceLocation(244, 66, 435, 307);
            return faceLocation;
        }

        throw new Exception("tagging");
    }
    
    private static Integer[] setRehMRimA(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if(num == 2278){
            faceLocation = getFaceLocation(200, 92, 466, 367);
            return faceLocation;
        }
        if(num == 2279){
            faceLocation = getFaceLocation(558, 246, 604, 303);
            return faceLocation;
        }
        if(num == 2280){
            faceLocation = getFaceLocation(530, 286, 582, 357);
            return faceLocation;
        }
        if(num == 2281){
            faceLocation = getFaceLocation(334, 288, 400, 374);
            return faceLocation;
        }
        if(num == 2282){
            faceLocation = getFaceLocation(198, 97, 419, 398);
            return faceLocation;
        }
        if(num == 2283){
            faceLocation = getFaceLocation(455, 215, 539, 315);
            return faceLocation;
        }
        if(num == 2284){
            faceLocation = getFaceLocation(353, 54, 471, 218);
            return faceLocation;
        }
        if(num == 2285){
            faceLocation = getFaceLocation(82, 109, 306, 385);
            return faceLocation;
        }
        if(num == 2286){
            faceLocation = getFaceLocation(68, 63, 259, 342);
            return faceLocation;
        }
        if(num == 2287){
            faceLocation = getFaceLocation(313, 287, 363, 350);
            return faceLocation;
        }
        if(num == 2288){
            faceLocation = getFaceLocation(145, 117, 326, 351);
            return faceLocation;
        }
        if(num == 2289){
            faceLocation = getFaceLocation(207, 109, 390, 360);
            return faceLocation;
        }
        if(num == 2290){
            faceLocation = getFaceLocation(270, 86, 497, 435);
            return faceLocation;
        }
        if(num == 2291){
            faceLocation = getFaceLocation(246, 8, 342, 133);
            return faceLocation;
        }
        if(num == 2292){
            faceLocation = getFaceLocation(61, 64, 242, 319);
            return faceLocation;
        }
        if(num == 2293){
            faceLocation = getFaceLocation(336, 130, 408, 230);
            return faceLocation;
        }
        if(num == 2294){
            faceLocation = getFaceLocation(391, 118, 474, 221);
            return faceLocation;
        }
        if(num == 2295){
            faceLocation = getFaceLocation(381, 108, 578, 399);
            return faceLocation;
        }
        if(num == 2296){
            faceLocation = getFaceLocation(317, 97, 506, 314);
            return faceLocation;
        }
        if(num == 2297){
            faceLocation = getFaceLocation(441, 110, 633, 363);
            return faceLocation;
        }
        if(num == 2298){
            faceLocation = getFaceLocation(412, 136, 515, 270);
            return faceLocation;
        }
        if(num == 2299){
            faceLocation = getFaceLocation(134, 84, 420, 468);
            return faceLocation;
        }
        if(num == 2300){
            faceLocation = getFaceLocation(51, 2, 447, 458);
            return faceLocation;
        }
        if(num == 2301){
            faceLocation = getFaceLocation(123, 11, 249, 162);
            return faceLocation;
        }
        if(num == 2302){
            faceLocation = getFaceLocation(119, 78, 389, 448);
            return faceLocation;
        }
        if(num == 2303){
            faceLocation = getFaceLocation(186, 40, 418, 389);
            return faceLocation;
        }
        if(num == 2304){
            faceLocation = getFaceLocation(168, 92, 404, 431);
            return faceLocation;
        }
        if(num == 2305){
            faceLocation = getFaceLocation(124, 89, 361, 417);
            return faceLocation;
        }
        if(num == 2306){
            faceLocation = getFaceLocation(205, 106, 434, 426);
            return faceLocation;
        }

        throw new Exception("tagging");
    }
    
    private static Integer[] setReeS(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if(num == 2270){
            faceLocation = getFaceLocation(397, 41, 559, 251);
            return faceLocation;
        }
        if(num == 2271){
            faceLocation = getFaceLocation(247, 32, 370, 196);
            return faceLocation;
        }
        if(num == 2272){
            faceLocation = getFaceLocation(286, 43, 484, 365);
            return faceLocation;
        }
        if(num == 2273){
            faceLocation = getFaceLocation(208, 63, 485, 461);
            return faceLocation;
        }
        if(num == 2274){
            faceLocation = getFaceLocation(206, 122, 454, 455);
            return faceLocation;
        }
        if(num == 2275){
            faceLocation = getFaceLocation(263, 96, 434, 305);
            return faceLocation;
        }
        if(num == 2276){
            faceLocation = getFaceLocation(65, 2, 537, 435);
            return faceLocation;
        }
        if(num == 2277){
            faceLocation = getFaceLocation(169, 93, 399, 405);
            return faceLocation;
        }

        throw new Exception("tagging");
    }
    
    private static Integer[] setPetN(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if(num == 2262){
            faceLocation = getFaceLocation(162, 103, 444, 444);
            return faceLocation;
        }
        if(num == 2263){
            faceLocation = getFaceLocation(203, 91, 474, 444);
            return faceLocation;
        }
        if(num == 2264){
            faceLocation = getFaceLocation(137, 84, 451, 471);
            return faceLocation;
        }
        if(num == 2265){
            faceLocation = getFaceLocation(176, 97, 444, 447);
            return faceLocation;
        }
        if(num == 2266){
            faceLocation = getFaceLocation(145, 86, 447, 461);
            return faceLocation;
        }
        if(num == 2267){
            faceLocation = getFaceLocation(173, 81, 447, 444);
            return faceLocation;
        }
        if(num == 2268){
            faceLocation = getFaceLocation(153, 74, 445, 457);
            return faceLocation;
        }
        if(num == 2269){
            faceLocation = getFaceLocation(183, 91, 455, 451);
            return faceLocation;
        }

        throw new Exception("tagging");
    }
    
    private static Integer[] setPetK(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if(num == 2254){
            faceLocation = getFaceLocation(287, 82, 495, 364);
            return faceLocation;
        }
        if(num == 2255){
            faceLocation = getFaceLocation(189, 87, 393, 360);
            return faceLocation;
        }
        if(num == 2256){
            faceLocation = getFaceLocation(258, 48, 458, 309);
            return faceLocation;
        }
        if(num == 2257){
            faceLocation = getFaceLocation(263, 75, 470, 354);
            return faceLocation;
        }
        if(num == 2258){
            faceLocation = getFaceLocation(295, 61, 565, 444);
            return faceLocation;
        }
        if(num == 2259){
            faceLocation = getFaceLocation(202, 21, 460, 382);
            return faceLocation;
        }
        if(num == 2260){
            faceLocation = getFaceLocation(184, 82, 410, 386);
            return faceLocation;
        }
        if(num == 2261){
            faceLocation = getFaceLocation(201, 71, 465, 442);
            return faceLocation;
        }

        throw new Exception("tagging");
    }
    
    private static Integer[] setPetJ(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if(num == 2246){
            faceLocation = getFaceLocation(174, 98, 431, 451);
            return faceLocation;
        }
        if(num == 2247){
            faceLocation = getFaceLocation(152, 117, 459, 477);
            return faceLocation;
        }
        if(num == 2248){
            faceLocation = getFaceLocation(266, 87, 534, 435);
            return faceLocation;
        }
        if(num == 2249){
            faceLocation = getFaceLocation(178, 98, 470, 470);
            return faceLocation;
        }
        if(num == 2250){
            faceLocation = getFaceLocation(95, 91, 386, 474);
            return faceLocation;
        }
        if(num == 2251){
            faceLocation = getFaceLocation(132, 93, 407, 449);
            return faceLocation;
        }
        if(num == 2252){
            faceLocation = getFaceLocation(119, 144, 393, 472);
            return faceLocation;
        }
        if(num == 2253){
            faceLocation = getFaceLocation(130, 97, 413, 459);
            return faceLocation;
        }

        throw new Exception("tagging");
    }
    
    private static Integer[] setPetB(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if(num == 2238){
            faceLocation = getFaceLocation(206, 56, 457, 398);
            return faceLocation;
        }
        if(num == 2239){
            faceLocation = getFaceLocation(127, 100, 405, 477);
            return faceLocation;
        }
        if(num == 2240){
            faceLocation = getFaceLocation(204, 58, 468, 421);
            return faceLocation;
        }
        if(num == 2241){
            faceLocation = getFaceLocation(184, 71, 470, 477);
            return faceLocation;
        }
        if(num == 2242){
            faceLocation = getFaceLocation(147, 58, 446, 460);
            return faceLocation;
        }
        if(num == 2243){
            faceLocation = getFaceLocation(179, 76, 442, 420);
            return faceLocation;
        }
        if(num == 2244){
            faceLocation = getFaceLocation(156, 88, 434, 460);
            return faceLocation;
        }
        if(num == 2245){
            faceLocation = getFaceLocation(236, 111, 499, 459);
            return faceLocation;
        }

        throw new Exception("tagging");
    }
    
    private static Integer[] setOmaK(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if(num == 2231){
            faceLocation = getFaceLocation(154, 59, 424, 380);
            return faceLocation;
        }
        if(num == 2232){
            faceLocation = getFaceLocation(275, 102, 504, 406);
            return faceLocation;
        }
        if(num == 2233){
            faceLocation = getFaceLocation(184, 97, 449, 387);
            return faceLocation;
        }
        if(num == 2234){
            faceLocation = getFaceLocation(202, 98, 377, 305);
            return faceLocation;
        }
        if(num == 2235){
            faceLocation = getFaceLocation(271, 98, 466, 326);
            return faceLocation;
        }
        if(num == 2236){
            faceLocation = getFaceLocation(180, 110, 379, 371);
            return faceLocation;
        }
        if(num == 2237){
            faceLocation = getFaceLocation(210, 84, 383, 298);
            return faceLocation;
        }

        throw new Exception("tagging");
    }
    
    private static Integer[] setOliA(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if(num == 2053){
            faceLocation = getFaceLocation(214, 76, 401, 311);
            return faceLocation;
        }
        if(num == 2054){
            faceLocation = getFaceLocation(249, 57, 436, 294);
            return faceLocation;
        }
        if(num == 2055){
            faceLocation = getFaceLocation(214, 52, 399, 294);
            return faceLocation;
        }
        if(num == 2056){
            faceLocation = getFaceLocation(255, 62, 431, 286);
            return faceLocation;
        }
        if(num == 2057){
            faceLocation = getFaceLocation(311, 114, 429, 268);
            return faceLocation;
        }
        if(num == 2058){
            faceLocation = getFaceLocation(315, 111, 430, 268);
            return faceLocation;
        }
        if(num == 2059){
            faceLocation = getFaceLocation(312, 111, 431, 264);
            return faceLocation;
        }
        if(num >= 2060 && num <= 2064){
            faceLocation = getFaceLocation(306, 112, 436, 265);
            return faceLocation;
        }
        if(num >= 2065 && num <= 2069){
            faceLocation = getFaceLocation(299, 167, 430, 330);
            return faceLocation;
        }
        if(num >= 2070 && num <= 2072){
            faceLocation = getFaceLocation(304, 159, 430, 317);
            return faceLocation;
        }
        if(num >= 2073 && num <= 2075){
            faceLocation = getFaceLocation(326, 120, 447, 286);
            return faceLocation;
        }
        if(num == 2080 || num == 2081){
            faceLocation = getFaceLocation(274, 140, 390, 292);
            return faceLocation;
        }
        if(num >= 2076 && num <= 2079){
            faceLocation = getFaceLocation(297, 127, 422, 289);
            return faceLocation;
        }
        if(num >= 2082 && num <= 2089){
            faceLocation = getFaceLocation(312, 157, 427, 313);
            return faceLocation;
        }
        if(num >= 2090 && num <= 2093){
            faceLocation = getFaceLocation(289, 153, 419, 330);
            return faceLocation;
        }
        if(num == 2094){
            faceLocation = getFaceLocation(299, 143, 432, 307);
            return faceLocation;
        }
        if(num >= 2095 && num <= 2099){
            faceLocation = getFaceLocation(300, 147, 418, 307);
            return faceLocation;
        }
        if(num == 2100){
            faceLocation = getFaceLocation(284, 157, 410, 311);
            return faceLocation;
        }
        if(num == 2101){
            faceLocation = getFaceLocation(289, 152, 414, 312);
            return faceLocation;
        }
        if(num == 2102){
            faceLocation = getFaceLocation(297, 155, 434, 323);
            return faceLocation;
        }
        if(num == 2103){
            faceLocation = getFaceLocation(332, 151, 460, 324);
            return faceLocation;
        }
        if(num == 2104){
            faceLocation = getFaceLocation(0, 0, 0, 0);
            return faceLocation;
        }
        if(num == 2105){
            faceLocation = getFaceLocation(0, 0, 0, 0);
            return faceLocation;
        }
        if(num >= 2106 && num <= 2129){
            faceLocation = getFaceLocation(0, 0, 0, 0);
            return faceLocation;
        }
        if(num == 2130){
            faceLocation = getFaceLocation(313, 159, 438, 318);
            return faceLocation;
        }
        if(num == 2131){
            faceLocation = getFaceLocation(313, 155, 443, 321);
            return faceLocation;
        }
        if(num == 2132){
            faceLocation = getFaceLocation(309, 154, 437, 320);
            return faceLocation;
        }
        if(num >= 2133 && num <= 2139){
            faceLocation = getFaceLocation(309, 152, 435, 315);
            return faceLocation;
        }
        if(num >= 2140 && num <= 2149){
            faceLocation = getFaceLocation(326, 159, 450, 323);
            return faceLocation;
        }
        if(num >= 2150 && num <= 2159){
            faceLocation = getFaceLocation(311, 160, 447, 344);
            return faceLocation;
        }
        if(num >= 2160 && num <= 2169){
            faceLocation = getFaceLocation(309, 151, 442, 326);
            return faceLocation;
        }
        if(num >= 2170 && num <= 2179){
            faceLocation = getFaceLocation(300, 162, 438, 345);
            return faceLocation;
        }
        if(num >= 2180 && num <= 2189){
            faceLocation = getFaceLocation(303, 164, 440, 337);
            return faceLocation;
        }
        if(num >= 2190 && num <= 2199){
            faceLocation = getFaceLocation(308, 150, 425, 317);
            return faceLocation;
        }
        if(num >= 2200 && num <= 2209){
            faceLocation = getFaceLocation(299, 157, 431, 319);
            return faceLocation;
        }
        if(num >= 2210 && num <= 2219){
            faceLocation = getFaceLocation(291, 153, 431, 334);
            return faceLocation;
        }
        if(num >= 2220 && num <= 2229){
            faceLocation = getFaceLocation(305, 154, 442, 329);
            return faceLocation;
        }
        if(num == 2230){
            faceLocation = getFaceLocation(217, 30, 469, 384);
            return faceLocation;
        }


        throw new Exception("tagging");
    }
    
    private static Integer[] setNohSNorA(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if(num == 2043){
            faceLocation = getFaceLocation(18, 51, 229, 300);
            return faceLocation;
        }
        if(num == 2044){
            faceLocation = getFaceLocation(87, 59, 306, 324);
            return faceLocation;
        }
        if(num == 2045){
            faceLocation = getFaceLocation(144, 60, 398, 363);
            return faceLocation;
        }
        if(num == 2046){
            faceLocation = getFaceLocation(12, 80, 230, 381);
            return faceLocation;
        }
        if(num == 2047){
            faceLocation = getFaceLocation(94, 103, 311, 340);
            return faceLocation;
        }
        if(num == 2048){
            faceLocation = getFaceLocation(204, 2, 480, 283);
            return faceLocation;
        }
        if(num == 2049){
            faceLocation = getFaceLocation(342, 104, 542, 371);
            return faceLocation;
        }
        if(num == 2050){
            faceLocation = getFaceLocation(164, 73, 345, 316);
            return faceLocation;
        }
        if(num == 2051){
            faceLocation = getFaceLocation(167, 145, 380, 393);
            return faceLocation;
        }
        if(num == 2052){
            faceLocation = getFaceLocation(187, 144, 398, 380);
            return faceLocation;
        }

        throw new Exception("tagging");
    }
    
    private static Integer[] setNasHNerF(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if(num == 2033){
            faceLocation = getFaceLocation(177, 68, 330, 256);
            return faceLocation;
        }
        if(num == 2034){
            faceLocation = getFaceLocation(127, 1, 593, 478);
            return faceLocation;
        }
        if(num == 2035){
            faceLocation = getFaceLocation(110, 85, 378, 425);
            return faceLocation;
        }
        if(num == 2036){
            faceLocation = getFaceLocation(173, 53, 430, 403);
            return faceLocation;
        }
        if(num == 2037){
            faceLocation = getFaceLocation(136, 74, 344, 349);
            return faceLocation;
        }
        if(num == 2038){
            faceLocation = getFaceLocation(211, 51, 522, 471);
            return faceLocation;
        }
        if(num == 2039){
            faceLocation = getFaceLocation(378, 111, 564, 380);
            return faceLocation;
        }
        if(num == 2040){
            faceLocation = getFaceLocation(68, 54, 259, 293);
            return faceLocation;
        }
        if(num == 2041){
            faceLocation = getFaceLocation(289, 51, 510, 366);
            return faceLocation;
        }
        if(num == 2042){
            faceLocation = getFaceLocation(246, 85, 458, 343);
            return faceLocation;
        }

        throw new Exception("tagging");
    }
    
    private static Integer[] setNasA(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if(num == 2027){
            faceLocation = getFaceLocation(184, 89, 426, 405);
            return faceLocation;
        }
        if(num == 2028){
            faceLocation = getFaceLocation(114, 84, 346, 369);
            return faceLocation;
        }
        if(num == 2029){
            faceLocation = getFaceLocation(237, 125, 480, 434);
            return faceLocation;
        }
        if(num == 2030){
            faceLocation = getFaceLocation(236, 53, 429, 324);
            return faceLocation;
        }
        if(num == 2031){
            faceLocation = getFaceLocation(82, 6, 203, 161);
            return faceLocation;
        }
        if(num == 2032){
            faceLocation = getFaceLocation(253, 19, 526, 472);
            return faceLocation;
        }

        throw new Exception("tagging");
    }
    
    private static Integer[] setNahA(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if(num == 2018){
            faceLocation = getFaceLocation(265, 119, 493, 355);
            return faceLocation;
        }
        if(num == 2019){
            faceLocation = getFaceLocation(254, 116, 489, 375);
            return faceLocation;
        }
        if(num == 2020){
            faceLocation = getFaceLocation(250, 117, 478, 372);
            return faceLocation;
        }
        if(num == 2021){
            faceLocation = getFaceLocation(168, 98, 407, 346);
            return faceLocation;
        }
        if(num == 2022){
            faceLocation = getFaceLocation(202, 112, 440, 360);
            return faceLocation;
        }
        if(num == 2023){
            faceLocation = getFaceLocation(166, 117, 406, 374);
            return faceLocation;
        }
        if(num == 2024){
            faceLocation = getFaceLocation(344, 139, 574, 367);
            return faceLocation;
        }
        if(num == 2025){
            faceLocation = getFaceLocation(98, 149, 310, 364);
            return faceLocation;
        }
        if(num == 2026){
            faceLocation = getFaceLocation(350, 127, 563, 353);
            return faceLocation;
        }

        throw new Exception("tagging");
    }
    
    private static Integer[] setMirEMyrM(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if(num == 2008){
            faceLocation = getFaceLocation(376, 176, 538, 356);
            return faceLocation;
        }
        if(num == 2009){
            faceLocation = getFaceLocation(265, 157, 428, 349);
            return faceLocation;
        }
        if(num == 2010){
            faceLocation = getFaceLocation(332, 127, 508, 313);
            return faceLocation;
        }
        if(num == 2011){
            faceLocation = getFaceLocation(147, 24, 487, 451);
            return faceLocation;
        }
        if(num == 2012){
            faceLocation = getFaceLocation(226, 2, 541, 327);
            return faceLocation;
        }
        if(num == 2013){
            faceLocation = getFaceLocation(251, 66, 561, 465);
            return faceLocation;
        }
        if(num == 2014){
            faceLocation = getFaceLocation(187, 70, 398, 365);
            return faceLocation;
        }
        if(num == 2015){
            faceLocation = getFaceLocation(232, 35, 437, 341);
            return faceLocation;
        }
        if(num == 2016){
            faceLocation = getFaceLocation(203, 117, 481, 462);
            return faceLocation;
        }
        if(num == 2017){
            faceLocation = getFaceLocation(100, 42, 431, 471);
            return faceLocation;
        }

        throw new Exception("tagging");
    }
    
    private static Integer[] setMotM(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if(num == 1976){
            faceLocation = getFaceLocation(138, 77, 436, 470);
            return faceLocation;
        }
        if(num == 1977){
            faceLocation = getFaceLocation(161, 84, 456, 478);
            return faceLocation;
        }
        if(num == 1978){
            faceLocation = getFaceLocation(141, 92, 420, 473);
            return faceLocation;
        }
        if(num == 1979){
            faceLocation = getFaceLocation(151, 95, 429, 479);
            return faceLocation;
        }
        if(num == 1980){
            faceLocation = getFaceLocation(142, 95, 436, 479);
            return faceLocation;
        }
        if(num == 1981){
            faceLocation = getFaceLocation(152, 79, 450, 475);
            return faceLocation;
        }
        if(num == 1982){
            faceLocation = getFaceLocation(151, 72, 447, 462);
            return faceLocation;
        }
        if(num == 1983){
            faceLocation = getFaceLocation(171, 74, 467, 464);
            return faceLocation;
        }
        if(num == 1984){
            faceLocation = getFaceLocation(114, 79, 405, 469);
            return faceLocation;
        }
        if(num == 1985){
            faceLocation = getFaceLocation(180, 92, 467, 465);
            return faceLocation;
        }
        if(num == 1986){
            faceLocation = getFaceLocation(163, 77, 441, 459);
            return faceLocation;
        }
        if(num == 1987){
            faceLocation = getFaceLocation(137, 81, 425, 466);
            return faceLocation;
        }
        if(num == 1988){
            faceLocation = getFaceLocation(168, 73, 449, 466);
            return faceLocation;
        }
        if(num == 1989){
            faceLocation = getFaceLocation(136, 92, 423, 463);
            return faceLocation;
        }
        if(num == 1990){
            faceLocation = getFaceLocation(200, 84, 497, 471);
            return faceLocation;
        }
        if(num == 1991){
            faceLocation = getFaceLocation(128, 86, 410, 458);
            return faceLocation;
        }
        if(num == 1992){
            faceLocation = getFaceLocation(128, 92, 413, 475);
            return faceLocation;
        }
        if(num == 1993){
            faceLocation = getFaceLocation(161, 86, 457, 458);
            return faceLocation;
        }
        if(num == 1994){
            faceLocation = getFaceLocation(160, 68, 432, 442);
            return faceLocation;
        }
        if(num == 1995){
            faceLocation = getFaceLocation(136, 73, 413, 452);
            return faceLocation;
        }
        if(num == 1996){
            faceLocation = getFaceLocation(145, 100, 436, 473);
            return faceLocation;
        }
        if(num == 1997){
            faceLocation = getFaceLocation(165, 80, 449, 461);
            return faceLocation;
        }
        if(num == 1998){
            faceLocation = getFaceLocation(217, 95, 482, 472);
            return faceLocation;
        }
        if(num == 1999){
            faceLocation = getFaceLocation(188, 75, 467, 464);
            return faceLocation;
        }
        if(num == 2000){
            faceLocation = getFaceLocation(150, 89, 437, 467);
            return faceLocation;
        }
        if(num == 2001){
            faceLocation = getFaceLocation(153, 85, 431, 457);
            return faceLocation;
        }
        if(num == 2002){
            faceLocation = getFaceLocation(166, 92, 440, 466);
            return faceLocation;
        }
        if(num == 2003){
            faceLocation = getFaceLocation(163, 106, 447, 474);
            return faceLocation;
        }
        if(num == 2004){
            faceLocation = getFaceLocation(165, 101, 447, 471);
            return faceLocation;
        }
        if(num == 2005){
            faceLocation = getFaceLocation(116, 78, 391, 431);
            return faceLocation;
        }
        if(num == 2006){
            faceLocation = getFaceLocation(183, 78, 476, 474);
            return faceLocation;
        }
        if(num == 2007){
            faceLocation = getFaceLocation(168, 63, 441, 435);
            return faceLocation;
        }

        throw new Exception("tagging");
    }
    
    private static Integer[] setMonMMosBMosK(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if(num == 1962){
            faceLocation = getFaceLocation(246, 61, 438, 305);
            return faceLocation;
        }
        if(num == 1963){
            faceLocation = getFaceLocation(242, 59, 458, 334);
            return faceLocation;
        }
        if(num == 1964){
            faceLocation = getFaceLocation(282, 78, 475, 333);
            return faceLocation;
        }
        if(num == 1965){
            faceLocation = getFaceLocation(227, 51, 465, 290);
            return faceLocation;
        }
        if(num == 1966){
            faceLocation = getFaceLocation(268, 93, 510, 423);
            return faceLocation;
        }
        if(num == 1967){
            faceLocation = getFaceLocation(65, 25, 250, 260);
            return faceLocation;
        }
        if(num == 1968){
            faceLocation = getFaceLocation(162, 84, 404, 375);
            return faceLocation;
        }
        if(num == 1969){
            faceLocation = getFaceLocation(234, 97, 493, 416);
            return faceLocation;
        }
        if(num == 1970){
            faceLocation = getFaceLocation(142, 102, 408, 431);
            return faceLocation;
        }
        if(num == 1971){
            faceLocation = getFaceLocation(185, 48, 458, 400);
            return faceLocation;
        }
        if(num == 1972){
            faceLocation = getFaceLocation(239, 81, 498, 401);
            return faceLocation;
        }
        if(num == 1973){
            faceLocation = getFaceLocation(191, 70, 453, 396);
            return faceLocation;
        }
        if(num == 1974){
            faceLocation = getFaceLocation(217, 84, 467, 428);
            return faceLocation;
        }
        if(num == 1975){
            faceLocation = getFaceLocation(242, 48, 499, 388);
            return faceLocation;
        }

        throw new Exception("tagging");
    }
    
    private static Integer[] setMonD(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if(num == 1954){
            faceLocation = getFaceLocation(474, 46, 614, 235);
            return faceLocation;
        }
        if(num == 1955){
            faceLocation = getFaceLocation(22, 122, 244, 414);
            return faceLocation;
        }
        if(num == 1956){
            faceLocation = getFaceLocation(291, 111, 521, 419);
            return faceLocation;
        }
        if(num == 1957){
            faceLocation = getFaceLocation(134, 34, 519, 466);
            return faceLocation;
        }
        if(num == 1958){
            faceLocation = getFaceLocation(215, 78, 504, 458);
            return faceLocation;
        }
        if(num == 1959){
            faceLocation = getFaceLocation(322, 119, 631, 449);
            return faceLocation;
        }
        if(num == 1960){
            faceLocation = getFaceLocation(160, 107, 411, 390);
            return faceLocation;
        }
        if(num == 1961){
            faceLocation = getFaceLocation(29, 144, 265, 436);
            return faceLocation;
        }

        throw new Exception("tagging");
    }
    
    private static Integer[] setMohN(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if(num == 1946){
            faceLocation = getFaceLocation(216, 104, 431, 375);
            return faceLocation;
        }
        if(num == 1947){
            faceLocation = getFaceLocation(296, 85, 463, 290);
            return faceLocation;
        }
        if(num == 1948){
            faceLocation = getFaceLocation(287, 77, 451, 276);
            return faceLocation;
        }
        if(num == 1949){
            faceLocation = getFaceLocation(199, 86, 365, 301);
            return faceLocation;
        }
        if(num == 1950){
            faceLocation = getFaceLocation(241, 70, 407, 278);
            return faceLocation;
        }
        if(num == 1951){
            faceLocation = getFaceLocation(225, 81, 385, 303);
            return faceLocation;
        }
        if(num == 1952){
            faceLocation = getFaceLocation(225, 86, 408, 332);
            return faceLocation;
        }
        if(num == 1953){
            faceLocation = getFaceLocation(242, 59, 432, 309);
            return faceLocation;
        }

        throw new Exception("tagging");
    }
    
    private static Integer[] setMohH(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if(num == 1942){
            faceLocation = getFaceLocation(149, 78, 424, 455);
            return faceLocation;
        }
        if(num == 1943){
            faceLocation = getFaceLocation(126, 95, 372, 404);
            return faceLocation;
        }
        if(num == 1944){
            faceLocation = getFaceLocation(159, 114, 411, 438);
            return faceLocation;
        }
        if(num == 1945){
            faceLocation = getFaceLocation(134, 67, 500, 479);
            return faceLocation;
        }

        throw new Exception("tagging");
    }
    
    private static Integer[] setMohG(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if(num >= 1713 && num <= 1719){
            faceLocation = getFaceLocation(208, 83, 368, 282);
            return faceLocation;
        }
        if(num >= 1720 && num <= 1729){
            faceLocation = getFaceLocation(219, 66, 376, 266);
            return faceLocation;
        }
        if(num >= 1730 && num <= 1739){
            faceLocation = getFaceLocation(215, 94, 372, 292);
            return faceLocation;
        }
        if(num >= 1740 && num <= 1749){
            faceLocation = getFaceLocation(200, 87, 366, 286);
            return faceLocation;
        }
        if(num >= 1750 && num <= 1759){
            faceLocation = getFaceLocation(206, 92, 376, 290);
            return faceLocation;
        }
        if(num >= 1760 && num <= 1769){
            faceLocation = getFaceLocation(213, 81, 381, 290);
            return faceLocation;
        }
        if(num >= 1770 && num <= 1779){
            faceLocation = getFaceLocation(209, 93, 368, 288);
            return faceLocation;
        }
        if(num >= 1780 && num <= 1789){
            faceLocation = getFaceLocation(211, 94, 372, 289);
            return faceLocation;
        }
        if(num >= 1790 && num <= 1799){
            faceLocation = getFaceLocation(202, 86, 382, 303);
            return faceLocation;
        }
        if(num >= 1800 && num <= 1809){
            faceLocation = getFaceLocation(213, 88, 374, 287);
            return faceLocation;
        }
        if(num >= 1810 && num <= 1819){
            faceLocation = getFaceLocation(210, 78, 375, 295);
            return faceLocation;
        }
        if(num >= 1820 && num <= 1829){
            faceLocation = getFaceLocation(209, 76, 377, 299);
            return faceLocation;
        }
        if(num >= 1830 && num <= 1839){
            faceLocation = getFaceLocation(208, 69, 378, 289);
            return faceLocation;
        }
        if(num >= 1840 && num <= 1849){
            faceLocation = getFaceLocation(209, 77, 377, 295);
            return faceLocation;
        }
        if(num >= 1850 && num <= 1859){
            faceLocation = getFaceLocation(206, 87, 364, 277);
            return faceLocation;
        }
        if(num >= 1860 && num <= 1869){
            faceLocation = getFaceLocation(212, 87, 372, 285);
            return faceLocation;
        }
        if(num >= 1870 && num <= 1879){
            faceLocation = getFaceLocation(209, 92, 376, 294);
            return faceLocation;
        }
        if(num >= 1880 && num <= 1889){
            faceLocation = getFaceLocation(214, 83, 375, 284);
            return faceLocation;
        }
        if(num >= 1890 && num <= 1899){
            faceLocation = getFaceLocation(206, 89, 375, 290);
            return faceLocation;
        }
        if(num >= 1900 && num <= 1909){
            faceLocation = getFaceLocation(211, 99, 382, 292);
            return faceLocation;
        }
        if(num >= 1910 && num <= 1919){
            faceLocation = getFaceLocation(215, 90, 374, 294);
            return faceLocation;
        }
        if(num >= 1920 && num <= 1929){
            faceLocation = getFaceLocation(214, 90, 377, 293);
            return faceLocation;
        }
        if(num >= 1930 && num <= 1939){
            faceLocation = getFaceLocation(212, 92, 369, 292);
            return faceLocation;
        }
        if(num >= 1940 && num <= 1941){
            faceLocation = getFaceLocation(211, 94, 372, 294);
            return faceLocation;
        }

        throw new Exception("tagging");
    }
    
    private static Integer[] setMirTMnyAMohABF(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if(num == 1676){
            faceLocation = getFaceLocation(157, 74, 399, 400);
            return faceLocation;
        }
        if(num == 1677){
            faceLocation = getFaceLocation(104, 55, 319, 358);
            return faceLocation;
        }
        if(num == 1678){
            faceLocation = getFaceLocation(128, 86, 310, 326);
            return faceLocation;
        }
        if(num == 1679){
            faceLocation = getFaceLocation(85, 113, 239, 329);
            return faceLocation;
        }
        if(num == 1680){
            faceLocation = getFaceLocation(363, 74, 613, 422);
            return faceLocation;
        }
        if(num == 1681){
            faceLocation = getFaceLocation(100, 109, 297, 385);
            return faceLocation;
        }
        if(num == 1682){
            faceLocation = getFaceLocation(183, 212, 361, 418);
            return faceLocation;
        }
        if(num == 1683){
            faceLocation = getFaceLocation(233, 86, 492, 443);
            return faceLocation;
        }
        if(num == 1684){
            faceLocation = getFaceLocation(44, 139, 235, 382);
            return faceLocation;
        }
        if(num == 1685){
            faceLocation = getFaceLocation(143, 87, 427, 468);
            return faceLocation;
        }
        if(num == 1686){
            faceLocation = getFaceLocation(46, 80, 230, 320);
            return faceLocation;
        }
        if(num == 1687){
            faceLocation = getFaceLocation(77, 60, 342, 419);
            return faceLocation;
        }
        if(num == 1688){
            faceLocation = getFaceLocation(134, 71, 332, 354);
            return faceLocation;
        }
        if(num == 1689){
            faceLocation = getFaceLocation(120, 90, 358, 385);
            return faceLocation;
        }
        if(num == 1690){
            faceLocation = getFaceLocation(66, 35, 351, 435);
            return faceLocation;
        }
        if(num == 1691){
            faceLocation = getFaceLocation(512, 261, 612, 386);
            return faceLocation;
        }
        if(num == 1692){
            faceLocation = getFaceLocation(298, 101, 526, 411);
            return faceLocation;
        }
        if(num == 1693){
            faceLocation = getFaceLocation(271, 46, 584, 479);
            return faceLocation;
        }
        if(num == 1694){
            faceLocation = getFaceLocation(192, 139, 415, 428);
            return faceLocation;
        }
        if(num == 1695){
            faceLocation = getFaceLocation(311, 46, 521, 323);
            return faceLocation;
        }
        if(num == 1696){
            faceLocation = getFaceLocation(62, 92, 356, 437);
            return faceLocation;
        }
        if(num == 1697){
            faceLocation = getFaceLocation(222, 153, 454, 418);
            return faceLocation;
        }
        if(num == 1698){
            faceLocation = getFaceLocation(307, 56, 553, 378);
            return faceLocation;
        }
        if(num == 1699){
            faceLocation = getFaceLocation(214, 79, 442, 384);
            return faceLocation;
        }
        if(num == 1700){
            faceLocation = getFaceLocation(80, 42, 337, 350);
            return faceLocation;
        }
        if(num == 1701){
            faceLocation = getFaceLocation(123, 77, 313, 332);
            return faceLocation;
        }
        if(num == 1702){
            faceLocation = getFaceLocation(171, 118, 447, 441);
            return faceLocation;
        }
        if(num == 1703){
            faceLocation = getFaceLocation(279, 84, 581, 469);
            return faceLocation;
        }
        if(num == 1704){
            faceLocation = getFaceLocation(229, 83, 391, 299);
            return faceLocation;
        }
        if(num == 1705){
            faceLocation = getFaceLocation(78, 94, 385, 467);
            return faceLocation;
        }
        if(num == 1706){
            faceLocation = getFaceLocation(27, 84, 321, 462);
            return faceLocation;
        }
        if(num == 1707){
            faceLocation = getFaceLocation(200, 114, 471, 450);
            return faceLocation;
        }
        if(num == 1708){
            faceLocation = getFaceLocation(63, 99, 371, 473);
            return faceLocation;
        }
        if(num == 1709){
            faceLocation = getFaceLocation(123, 81, 430, 451);
            return faceLocation;
        }
        if(num == 1710){
            faceLocation = getFaceLocation(181, 72, 372, 305);
            return faceLocation;
        }
        if(num == 1711){
            faceLocation = getFaceLocation(68, 107, 224, 298);
            return faceLocation;
        }
        if(num == 1712){
            faceLocation = getFaceLocation(333, 71, 463, 245);
            return faceLocation;
        }

        throw new Exception("tagging");
    }
    
    private static Integer[] setMhmAMirM(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if(num == 1575){
            faceLocation = getFaceLocation(114, 52, 391, 407);
            return faceLocation;
        }
        if(num == 1576){
            faceLocation = getFaceLocation(162, 72, 296, 254);
            return faceLocation;
        }
        if(num == 1577){
            faceLocation = getFaceLocation(128, 169, 283, 365);
            return faceLocation;
        }
        if(num == 1578){
            faceLocation = getFaceLocation(212, 148, 354, 282);
            return faceLocation;
        }
        if(num == 1579){
            faceLocation = getFaceLocation(28, 95, 293, 424);
            return faceLocation;
        }
        if(num == 1580){
            faceLocation = getFaceLocation(167, 161, 397, 395);
            return faceLocation;
        }
        if(num == 1581){
            faceLocation = getFaceLocation(225, 179, 370, 322);
            return faceLocation;
        }
        if(num >= 1582 && num <= 1589){
            faceLocation = getFaceLocation(231, 218, 357, 377);
            return faceLocation;
        }
        if(num >= 1590 && num <= 1599){
            faceLocation = getFaceLocation(231, 218, 355, 382);
            return faceLocation;
        }
        if(num >= 1600 && num <= 1609){
            faceLocation = getFaceLocation(240, 219, 381, 380);
            return faceLocation;
        }
        if(num >= 1610 && num <= 1619){
            faceLocation = getFaceLocation(242, 218, 377, 382);
            return faceLocation;
        }
        if(num >= 1620 && num <= 1629){
            faceLocation = getFaceLocation(245, 213, 383, 396);
            return faceLocation;
        }
        if(num >= 1630 && num <= 1639){
            faceLocation = getFaceLocation(250, 220, 384, 392);
            return faceLocation;
        }
        if(num >= 1640 && num <= 1649){
            faceLocation = getFaceLocation(249, 216, 376, 387);
            return faceLocation;
        }
        if(num >= 1650 && num <= 1659){
            faceLocation = getFaceLocation(242, 210, 372, 370);
            return faceLocation;
        }
        if(num >= 1660 && num <= 1669){
            faceLocation = getFaceLocation(246, 224, 378, 385);
            return faceLocation;
        }
        if(num >= 1670 && num <= 1672){
            faceLocation = getFaceLocation(227, 223, 364, 385);
            return faceLocation;
        }
        if(num == 1673){
            faceLocation = getFaceLocation(222, 225, 373, 391);
            return faceLocation;
        }
        if(num == 1674){
            faceLocation = getFaceLocation(203, 204, 422, 425);
            return faceLocation;
        }
        if(num == 1675){
            faceLocation = getFaceLocation(193, 129, 445, 381);
            return faceLocation;
        }

        throw new Exception("tagging");
    }
    
    private static Integer[] setMerN(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if(num == 1543){
            faceLocation = getFaceLocation(190, 75, 473, 441);
            return faceLocation;
        }
        if(num == 1544){
            faceLocation = getFaceLocation(146, 81, 443, 445);
            return faceLocation;
        }
        if(num == 1545){
            faceLocation = getFaceLocation(148, 85, 450, 448);
            return faceLocation;
        }
        if(num == 1546){
            faceLocation = getFaceLocation(132, 72, 396, 414);
            return faceLocation;
        }
        if(num == 1547){
            faceLocation = getFaceLocation(132, 92, 382, 424);
            return faceLocation;
        }
        if(num == 1548){
            faceLocation = getFaceLocation(147, 74, 409, 414);
            return faceLocation;
        }
        if(num == 1549){
            faceLocation = getFaceLocation(179, 81, 454, 416);
            return faceLocation;
        }
        if(num == 1550){
            faceLocation = getFaceLocation(232, 104, 467, 408);
            return faceLocation;
        }
        if(num == 1551){
            faceLocation = getFaceLocation(182, 47, 444, 414);
            return faceLocation;
        }
        if(num == 1552){
            faceLocation = getFaceLocation(180, 72, 447, 439);
            return faceLocation;
        }
        if(num == 1553){
            faceLocation = getFaceLocation(193, 92, 460, 447);
            return faceLocation;
        }
        if(num == 1554){
            faceLocation = getFaceLocation(147, 90, 398, 415);
            return faceLocation;
        }
        if(num == 1555){
            faceLocation = getFaceLocation(121, 121, 349, 426);
            return faceLocation;
        }
        if(num == 1556){
            faceLocation = getFaceLocation(126, 107, 375, 428);
            return faceLocation;
        }
        if(num == 1557){
            faceLocation = getFaceLocation(150, 66, 407, 421);
            return faceLocation;
        }
        if(num == 1558){
            faceLocation = getFaceLocation(124, 85, 330, 385);
            return faceLocation;
        }
        if(num == 1559){
            faceLocation = getFaceLocation(205, 55, 474, 413);
            return faceLocation;
        }
        if(num == 1560){
            faceLocation = getFaceLocation(203, 59, 472, 422);
            return faceLocation;
        }
        if(num == 1561){
            faceLocation = getFaceLocation(217, 51, 485, 424);
            return faceLocation;
        }
        if(num == 1562){
            faceLocation = getFaceLocation(124, 75, 358, 370);
            return faceLocation;
        }
        if(num == 1563){
            faceLocation = getFaceLocation(92, 95, 324, 387);
            return faceLocation;
        }
        if(num == 1564){
            faceLocation = getFaceLocation(192, 98, 417, 390);
            return faceLocation;
        }
        if(num == 1565){
            faceLocation = getFaceLocation(160, 73, 431, 423);
            return faceLocation;
        }
        if(num == 1566){
            faceLocation = getFaceLocation(154, 76, 378, 377);
            return faceLocation;
        }
        if(num == 1567){
            faceLocation = getFaceLocation(122, 90, 400, 450);
            return faceLocation;
        }
        if(num == 1568){
            faceLocation = getFaceLocation(172, 88, 445, 446);
            return faceLocation;
        }
        if(num == 1569){
            faceLocation = getFaceLocation(184, 83, 460, 450);
            return faceLocation;
        }
        if(num == 1570){
            faceLocation = getFaceLocation(140, 85, 356, 401);
            return faceLocation;
        }
        if(num == 1571){
            faceLocation = getFaceLocation(194, 102, 420, 403);
            return faceLocation;
        }
        if(num == 1572){
            faceLocation = getFaceLocation(158, 92, 387, 393);
            return faceLocation;
        }
        if(num == 1573){
            faceLocation = getFaceLocation(211, 80, 434, 365);
            return faceLocation;
        }
        if(num == 1574){
            faceLocation = getFaceLocation(153, 76, 424, 429);
            return faceLocation;
        }

        throw new Exception("tagging");
    }
    
    private static Integer[] setMerM(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if(num == 1398){
            faceLocation = getFaceLocation(244, 32, 450, 308);
            return faceLocation;
        }
        if(num >= 1399 && num <= 1409){
            faceLocation = getFaceLocation(220, 180, 350, 356);
            return faceLocation;
        }
        if(num >= 1410 && num <= 1419){
            faceLocation = getFaceLocation(225, 186, 371, 359);
            return faceLocation;
        }
        if(num >= 1420 && num <= 1429){
            faceLocation = getFaceLocation(226, 184, 365, 346);
            return faceLocation;
        }
        if(num >= 1430 && num <= 1439){
            faceLocation = getFaceLocation(237, 184, 369, 356);
            return faceLocation;
        }
        if(num >= 1440 && num <= 1449){
            faceLocation = getFaceLocation(225, 190, 370, 353);
            return faceLocation;
        }
        if(num >= 1450 && num <= 1459){
            faceLocation = getFaceLocation(221, 187, 371, 353);
            return faceLocation;
        }
        if(num >= 1460 && num <= 1469){
            faceLocation = getFaceLocation(225, 189, 373, 353);
            return faceLocation;
        }
        if(num >= 1470 && num <= 1479){
            faceLocation = getFaceLocation(237, 190, 378, 365);
            return faceLocation;
        }
        if(num >= 1480 && num <= 1489){
            faceLocation = getFaceLocation(226, 188, 365, 352);
            return faceLocation;
        }
        if(num >= 1490 && num <= 1499){
            faceLocation = getFaceLocation(231, 182, 365, 358);
            return faceLocation;
        }
        if(num >= 1500 && num <= 1509){
            faceLocation = getFaceLocation(229, 183, 367, 355);
            return faceLocation;
        }
        if(num >= 1510 && num <= 15019){
            faceLocation = getFaceLocation(233, 184, 370, 366);
            return faceLocation;
        }
        if(num >= 1520 && num <= 1529){
            faceLocation = getFaceLocation(233, 182, 372, 363);
            return faceLocation;
        }
        if(num >= 1530 && num <= 1538){
            faceLocation = getFaceLocation(232, 186, 371, 363);
            return faceLocation;
        }
        if(num == 1539){
            faceLocation = getFaceLocation(91, 93, 398, 414);
            return faceLocation;
        }
        if(num == 1540){
            faceLocation = getFaceLocation(222, 65, 499, 431);
            return faceLocation;
        }
        if(num == 1541){
            faceLocation = getFaceLocation(176, 96, 454, 412);
            return faceLocation;
        }
        if(num == 1542){
            faceLocation = getFaceLocation(196, 124, 435, 424);
            return faceLocation;
        }

        throw new Exception("tagging");
    }
    
    private static Integer[] setMerK(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if(num == 1351){
            faceLocation = getFaceLocation(112, 65, 434, 462);
            return faceLocation;
        }
        if(num == 1352){
            faceLocation = getFaceLocation(242, 86, 548, 471);
            return faceLocation;
        }
        if(num == 1353){
            faceLocation = getFaceLocation(168, 79, 494, 471);
            return faceLocation;
        }
        if(num == 1354){
            faceLocation = getFaceLocation(110, 72, 437, 453);
            return faceLocation;
        }
        if(num == 1355){
            faceLocation = getFaceLocation(120, 78, 445, 464);
            return faceLocation;
        }
        if(num == 1356){
            faceLocation = getFaceLocation(152, 88, 487, 474);
            return faceLocation;
        }
        if(num == 1357){
            faceLocation = getFaceLocation(214, 66, 562, 475);
            return faceLocation;
        }
        if(num == 1358){
            faceLocation = getFaceLocation(186, 75, 499, 453);
            return faceLocation;
        }
        if(num == 1359){
            faceLocation = getFaceLocation(155, 99, 493, 477);
            return faceLocation;
        }
        if(num == 1360){
            faceLocation = getFaceLocation(155, 72, 488, 470);
            return faceLocation;
        }
        if(num == 1361){
            faceLocation = getFaceLocation(154, 88, 490, 474);
            return faceLocation;
        }
        if(num == 1362){
            faceLocation = getFaceLocation(162, 67, 471, 447);
            return faceLocation;
        }
        if(num == 1363){
            faceLocation = getFaceLocation(187, 49, 510, 439);
            return faceLocation;
        }
        if(num == 1364){
            faceLocation = getFaceLocation(189, 66, 513, 464);
            return faceLocation;
        }
        if(num == 1365){
            faceLocation = getFaceLocation(171, 42, 514, 449);
            return faceLocation;
        }
        if(num == 1366){
            faceLocation = getFaceLocation(159, 72, 496, 462);
            return faceLocation;
        }
        if(num == 1367){
            faceLocation = getFaceLocation(325, 41, 542, 269);
            return faceLocation;
        }
        if(num == 1368){
            faceLocation = getFaceLocation(298, 112, 556, 435);
            return faceLocation;
        }
        if(num == 1369){
            faceLocation = getFaceLocation(198, 27, 566, 469);
            return faceLocation;
        }
        if(num == 1370){
            faceLocation = getFaceLocation(143, 89, 386, 400);
            return faceLocation;
        }
        if(num == 1371){
            faceLocation = getFaceLocation(164, 92, 414, 395);
            return faceLocation;
        }
        if(num == 1372){
            faceLocation = getFaceLocation(201, 77, 454, 384);
            return faceLocation;
        }
        if(num == 1373){
            faceLocation = getFaceLocation(167, 86, 457, 429);
            return faceLocation;
        }
        if(num == 1374){
            faceLocation = getFaceLocation(164, 67, 460, 408);
            return faceLocation;
        }
        if(num == 1375){
            faceLocation = getFaceLocation(129, 82, 408, 417);
            return faceLocation;
        }
        if(num == 1376){
            faceLocation = getFaceLocation(143, 83, 435, 438);
            return faceLocation;
        }
        if(num == 1377){
            faceLocation = getFaceLocation(139, 70, 389, 365);
            return faceLocation;
        }
        if(num == 1378){
            faceLocation = getFaceLocation(139, 73, 391, 359);
            return faceLocation;
        }
        if(num == 1379){
            faceLocation = getFaceLocation(188, 77, 430, 374);
            return faceLocation;
        }
        if(num == 1380){
            faceLocation = getFaceLocation(126, 95, 417, 438);
            return faceLocation;
        }
        if(num == 1381){
            faceLocation = getFaceLocation(156, 60, 444, 408);
            return faceLocation;
        }
        if(num == 1382){
            faceLocation = getFaceLocation(135, 99, 418, 439);
            return faceLocation;
        }
        if(num == 1383){
            faceLocation = getFaceLocation(123, 74, 415, 419);
            return faceLocation;
        }
        if(num == 1384){
            faceLocation = getFaceLocation(153, 100, 391, 389);
            return faceLocation;
        }
        if(num == 1385){
            faceLocation = getFaceLocation(131, 108, 372, 402);
            return faceLocation;
        }
        if(num == 1386){
            faceLocation = getFaceLocation(159, 67, 402, 383);
            return faceLocation;
        }
        if(num == 1387){
            faceLocation = getFaceLocation(99, 62, 386, 429);
            return faceLocation;
        }
        if(num == 1388){
            faceLocation = getFaceLocation(175, 124, 472, 462);
            return faceLocation;
        }
        if(num == 1389){
            faceLocation = getFaceLocation(191, 125, 475, 464);
            return faceLocation;
        }
        if(num == 1390){
            faceLocation = getFaceLocation(164, 103, 460, 448);
            return faceLocation;
        }
        if(num == 1391){
            faceLocation = getFaceLocation(124, 95, 373, 415);
            return faceLocation;
        }
        if(num == 1392){
            faceLocation = getFaceLocation(163, 81, 437, 430);
            return faceLocation;
        }
        if(num == 1393){
            faceLocation = getFaceLocation(152, 71, 430, 423);
            return faceLocation;
        }
        if(num == 1394){
            faceLocation = getFaceLocation(118, 78, 410, 422);
            return faceLocation;
        }
        if(num == 1395){
            faceLocation = getFaceLocation(166, 94, 448, 441);
            return faceLocation;
        }
        if(num == 1396){
            faceLocation = getFaceLocation(165, 68, 426, 383);
            return faceLocation;
        }
        if(num == 1397){
            faceLocation = getFaceLocation(150, 93, 417, 410);
            return faceLocation;
        }

        throw new Exception("tagging");
    }
    
    private static Integer[] setMeiHMerBMerD(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if(num == 1351){
            faceLocation = getFaceLocation(112, 65, 434, 462);
            return faceLocation;
        }
        if(num == 1352){
            faceLocation = getFaceLocation(242, 86, 548, 471);
            return faceLocation;
        }
        if(num == 1353){
            faceLocation = getFaceLocation(168, 79, 494, 471);
            return faceLocation;
        }
        if(num == 1354){
            faceLocation = getFaceLocation(110, 72, 437, 453);
            return faceLocation;
        }
        if(num == 1355){
            faceLocation = getFaceLocation(120, 78, 445, 464);
            return faceLocation;
        }
        if(num == 1356){
            faceLocation = getFaceLocation(152, 88, 487, 474);
            return faceLocation;
        }
        if(num == 1357){
            faceLocation = getFaceLocation(214, 66, 562, 475);
            return faceLocation;
        }
        if(num == 1358){
            faceLocation = getFaceLocation(186, 75, 499, 453);
            return faceLocation;
        }
        if(num == 1359){
            faceLocation = getFaceLocation(155, 99, 493, 477);
            return faceLocation;
        }
        if(num == 1360){
            faceLocation = getFaceLocation(155, 72, 488, 470);
            return faceLocation;
        }
        if(num == 1361){
            faceLocation = getFaceLocation(154, 88, 490, 474);
            return faceLocation;
        }
        if(num == 1362){
            faceLocation = getFaceLocation(162, 67, 471, 447);
            return faceLocation;
        }
        if(num == 1363){
            faceLocation = getFaceLocation(187, 49, 510, 439);
            return faceLocation;
        }
        if(num == 1364){
            faceLocation = getFaceLocation(189, 66, 513, 464);
            return faceLocation;
        }
        if(num == 1365){
            faceLocation = getFaceLocation(171, 42, 514, 449);
            return faceLocation;
        }
        if(num == 1366){
            faceLocation = getFaceLocation(159, 72, 496, 462);
            return faceLocation;
        }
        if(num == 1367){
            faceLocation = getFaceLocation(325, 41, 542, 269);
            return faceLocation;
        }
        if(num == 1368){
            faceLocation = getFaceLocation(298, 112, 556, 435);
            return faceLocation;
        }
        if(num == 1369){
            faceLocation = getFaceLocation(198, 27, 566, 469);
            return faceLocation;
        }

        throw new Exception("tagging");
    }
    
    private static Integer[] setMazR(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if(num == 1327){
            faceLocation = getFaceLocation(119, 67, 264, 265);
            return faceLocation;
        }
        if(num == 1328){
            faceLocation = getFaceLocation(131, 46, 337, 303);
            return faceLocation;
        }
        if(num == 1329){
            faceLocation = getFaceLocation(105, 51, 250, 231);
            return faceLocation;
        }
        if(num == 1330){
            faceLocation = getFaceLocation(239, 97, 456, 383);
            return faceLocation;
        }
        if(num == 1331){
            faceLocation = getFaceLocation(203, 170, 370, 389);
            return faceLocation;
        }
        if(num == 1332){
            faceLocation = getFaceLocation(146, 111, 339, 393);
            return faceLocation;
        }
        if(num == 1333){
            faceLocation = getFaceLocation(142, 77, 334, 321);
            return faceLocation;
        }
        if(num == 1334){
            faceLocation = getFaceLocation(101, 74, 328, 369);
            return faceLocation;
        }
        if(num == 1335){
            faceLocation = getFaceLocation(242, 92, 505, 420);
            return faceLocation;
        }
        if(num == 1336){
            faceLocation = getFaceLocation(328, 109, 509, 366);
            return faceLocation;
        }
        if(num == 1337){
            faceLocation = getFaceLocation(309, 121, 474, 322);
            return faceLocation;
        }
        if(num == 1338){
            faceLocation = getFaceLocation(157, 92, 321, 296);
            return faceLocation;
        }
        if(num == 1339){
            faceLocation = getFaceLocation(103, 62, 378, 457);
            return faceLocation;
        }
        if(num == 1340){
            faceLocation = getFaceLocation(148, 84, 333, 295);
            return faceLocation;
        }
        if(num == 1341){
            faceLocation = getFaceLocation(190, 89, 493, 466);
            return faceLocation;
        }
        if(num == 1342){
            faceLocation = getFaceLocation(172, 72, 392, 348);
            return faceLocation;
        }
        if(num == 1343){
            faceLocation = getFaceLocation(131, 51, 382, 355);
            return faceLocation;
        }
        if(num == 1344){
            faceLocation = getFaceLocation(210, 87, 449, 384);
            return faceLocation;
        }
        if(num == 1345){
            faceLocation = getFaceLocation(271, 56, 505, 349);
            return faceLocation;
        }
        if(num == 1346){
            faceLocation = getFaceLocation(266, 131, 519, 448);
            return faceLocation;
        }
        if(num == 1347){
            faceLocation = getFaceLocation(210, 60, 472, 395);
            return faceLocation;
        }
        if(num == 1348){
            faceLocation = getFaceLocation(247, 103, 514, 427);
            return faceLocation;
        }
        if(num == 1349){
            faceLocation = getFaceLocation(110, 110, 322, 370);
            return faceLocation;
        }
        if(num == 1350){
            faceLocation = getFaceLocation(61, 52, 328, 371);
            return faceLocation;
        }

        throw new Exception("tagging");
    }
    
    private static Integer[] setMahSlArErGrHrMrRrSyA(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if(num == 1268){
            faceLocation = getFaceLocation(258, 69, 413, 276);
            return faceLocation;
        }
        if(num == 1269){
            faceLocation = getFaceLocation(265, 67, 442, 298);
            return faceLocation;
        }
        if(num == 1270){
            faceLocation = getFaceLocation(151, 82, 338, 311);
            return faceLocation;
        }
        if(num == 1271){
            faceLocation = getFaceLocation(193, 58, 377, 271);
            return faceLocation;
        }
        if(num == 1272){
            faceLocation = getFaceLocation(218, 61, 406, 296);
            return faceLocation;
        }
        if(num == 1273){
            faceLocation = getFaceLocation(182, 113, 379, 350);
            return faceLocation;
        }
        if(num == 1274){
            faceLocation = getFaceLocation(243, 73, 430, 301);
            return faceLocation;
        }
        if(num == 1275){
            faceLocation = getFaceLocation(193, 63, 393, 314);
            return faceLocation;
        }
        if(num == 1276){
            faceLocation = getFaceLocation(214, 77, 460, 352);
            return faceLocation;
        }
        if(num == 1277){
            faceLocation = getFaceLocation(128, 47, 397, 338);
            return faceLocation;
        }
        if(num == 1278){
            faceLocation = getFaceLocation(168, 119, 404, 389);
            return faceLocation;
        }
        if(num == 1279){
            faceLocation = getFaceLocation(136, 92, 373, 353);
            return faceLocation;
        }
        if(num == 1280){
            faceLocation = getFaceLocation(139, 84, 397, 380);
            return faceLocation;
        }
        if(num == 1281){
            faceLocation = getFaceLocation(233, 129, 460, 393);
            return faceLocation;
        }
        if(num == 1282){
            faceLocation = getFaceLocation(208, 107, 528, 466);
            return faceLocation;
        }
        if(num == 1283){
            faceLocation = getFaceLocation(106, 61, 482, 462);
            return faceLocation;
        }
        if(num == 1284){
            faceLocation = getFaceLocation(202, 2, 518, 274);
            return faceLocation;
        }
        if(num == 1285){
            faceLocation = getFaceLocation(31, 1, 277, 217);
            return faceLocation;
        }
        if(num == 1286){
            faceLocation = getFaceLocation(50, 75, 202, 275);
            return faceLocation;
        }
        if(num == 1287){
            faceLocation = getFaceLocation(187, 35, 376, 304);
            return faceLocation;
        }
        if(num == 1288){
            faceLocation = getFaceLocation(276, 3, 563, 343);
            return faceLocation;
        }
        if(num == 1289){
            faceLocation = getFaceLocation(410, 109, 564, 348);
            return faceLocation;
        }
        if(num == 1290){
            faceLocation = getFaceLocation(381, 4, 599, 268);
            return faceLocation;
        }
        if(num == 1291){
            faceLocation = getFaceLocation(295, 31, 551, 339);
            return faceLocation;
        }
        if(num == 1292){
            faceLocation = getFaceLocation(251, 43, 422, 257);
            return faceLocation;
        }
        if(num == 1293){
            faceLocation = getFaceLocation(328, 37, 509, 268);
            return faceLocation;
        }
        if(num == 1294){
            faceLocation = getFaceLocation(46, 90, 207, 287);
            return faceLocation;
        }
        if(num == 1295){
            faceLocation = getFaceLocation(408, 46, 600, 278);
            return faceLocation;
        }
        if(num == 1296){
            faceLocation = getFaceLocation(327, 23, 586, 350);
            return faceLocation;
        }
        if(num == 1297){
            faceLocation = getFaceLocation(193, 47, 489, 429);
            return faceLocation;
        }
        if(num == 1298){
            faceLocation = getFaceLocation(180, 25, 489, 454);
            return faceLocation;
        }
        if(num == 1299){
            faceLocation = getFaceLocation(405, 234, 495, 338);
            return faceLocation;
        }
        if(num == 1300){
            faceLocation = getFaceLocation(418, 106, 616, 313);
            return faceLocation;
        }
        if(num == 1301){
            faceLocation = getFaceLocation(125, 199, 243, 313);
            return faceLocation;
        }
        if(num == 1302){
            faceLocation = getFaceLocation(463, 82, 629, 301);
            return faceLocation;
        }
        if(num == 1303){
            faceLocation = getFaceLocation(340, 99, 584, 418);
            return faceLocation;
        }
        if(num == 1304){
            faceLocation = getFaceLocation(482, 91, 630, 270);
            return faceLocation;
        }
        if(num == 1305){
            faceLocation = getFaceLocation(204, 58, 444, 386);
            return faceLocation;
        }
        if(num == 1306){
            faceLocation = getFaceLocation(191, 117, 349, 330);
            return faceLocation;
        }
        if(num == 1307){
            faceLocation = getFaceLocation(251, 135, 405, 336);
            return faceLocation;
        }
        if(num == 1308){
            faceLocation = getFaceLocation(241, 92, 454, 350);
            return faceLocation;
        }
        if(num == 1309){
            faceLocation = getFaceLocation(120, 150, 312, 412);
            return faceLocation;
        }
        if(num == 1310){
            faceLocation = getFaceLocation(176, 85, 422, 365);
            return faceLocation;
        }
        if(num == 1311){
            faceLocation = getFaceLocation(53, 92, 325, 432);
            return faceLocation;
        }
        if(num == 1312){
            faceLocation = getFaceLocation(79, 96, 317, 385);
            return faceLocation;
        }
        if(num == 1313){
            faceLocation = getFaceLocation(207, 89, 506, 457);
            return faceLocation;
        }
        if(num == 1314){
            faceLocation = getFaceLocation(189, 101, 426, 385);
            return faceLocation;
        }
        if(num == 1315){
            faceLocation = getFaceLocation(354, 130, 514, 310);
            return faceLocation;
        }
        if(num == 1316){
            faceLocation = getFaceLocation(265, 29, 544, 383);
            return faceLocation;
        }
        if(num == 1317){
            faceLocation = getFaceLocation(436, 64, 609, 281);
            return faceLocation;
        }
        if(num == 1318){
            faceLocation = getFaceLocation(345, 107, 559, 397);
            return faceLocation;
        }
        if(num == 1319){
            faceLocation = getFaceLocation(318, 71, 578, 403);
            return faceLocation;
        }
        if(num == 1320){
            faceLocation = getFaceLocation(385, 155, 602, 435);
            return faceLocation;
        }
        if(num == 1321){
            faceLocation = getFaceLocation(256, 83, 527, 412);
            return faceLocation;
        }
        if(num == 1322){
            faceLocation = getFaceLocation(285, 32, 598, 455);
            return faceLocation;
        }
        if(num == 1323){
            faceLocation = getFaceLocation(171, 55, 484, 448);
            return faceLocation;
        }
        if(num == 1324){
            faceLocation = getFaceLocation(434, 91, 615, 371);
            return faceLocation;
        }
        if(num == 1325){
            faceLocation = getFaceLocation(143, 128, 269, 325);
            return faceLocation;
        }
        if(num == 1326){
            faceLocation = getFaceLocation(102, 94, 347, 432);
            return faceLocation;
        }

        throw new Exception("tagging");
    }
    
    private static Integer[] setMahM(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if(num >= 1011 && num <= 1025){
            faceLocation = getFaceLocation(204, 109, 361, 279);
            return faceLocation;
        }
        if(num >= 1026 && num <= 1095){
            faceLocation = getFaceLocation(213, 112, 368, 280);
            return faceLocation;
        }
        if(num >= 1096 && num <= 10266){
            faceLocation = getFaceLocation(221, 92, 384, 274);
            return faceLocation;
        }
        if(num == 1267){
            faceLocation = getFaceLocation(208, 103, 361, 307);
            return faceLocation;
        }

        throw new Exception("tagging");
    }
    
    private static Integer[] setMahA(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if(num == 882){
            faceLocation = getFaceLocation(387, 232, 533, 413);
            return faceLocation;
        }
        if(num == 883){
            faceLocation = getFaceLocation(48, 128, 301, 441);
            return faceLocation;
        }
        if(num == 884){
            faceLocation = getFaceLocation(183, 63, 518, 459);
            return faceLocation;
        }
        if(num >= 885 && num <= 894){
            faceLocation = getFaceLocation(317, 127, 410, 244);
            return faceLocation;
        }
        if(num >= 895 && num <= 898){
            faceLocation = getFaceLocation(324, 132, 419, 243);
            return faceLocation;
        }
        if(num == 899){
            faceLocation = getFaceLocation(275, 41, 444, 266);
            return faceLocation;
        }
        if(num >= 900 && num <= 914){
            faceLocation = getFaceLocation(298, 7, 453, 205);
            return faceLocation;
        }
        if(num >= 915 && num <= 917){
            faceLocation = getFaceLocation(309, 17, 468, 224);
            return faceLocation;
        }
        if(num >= 918 && num <= 978){
            faceLocation = getFaceLocation(227, 213, 398, 405);
            return faceLocation;
        }
        if(num == 979){
            faceLocation = getFaceLocation(209, 108, 456, 406);
            return faceLocation;
        }
        if(num == 980){
            faceLocation = getFaceLocation(142, 81, 379, 368);
            return faceLocation;
        }
        if(num == 981){
            faceLocation = getFaceLocation(173, 74, 440, 439);
            return faceLocation;
        }
        if(num == 982){
            faceLocation = getFaceLocation(112, 67, 294, 286);
            return faceLocation;
        }
        if(num == 983){
            faceLocation = getFaceLocation(24, 93, 300, 460);
            return faceLocation;
        }
        if(num == 984){
            faceLocation = getFaceLocation(62, 59, 212, 244);
            return faceLocation;
        }
        if(num == 985){
            faceLocation = getFaceLocation(154, 66, 344, 330);
            return faceLocation;
        }
        if(num == 986){
            faceLocation = getFaceLocation(81, 45, 228, 241);
            return faceLocation;
        }
        if(num == 987){
            faceLocation = getFaceLocation(353, 80, 598, 429);
            return faceLocation;
        }
        if(num == 988){
            faceLocation = getFaceLocation(291, 145, 368, 250);
            return faceLocation;
        }
        if(num == 989){
            faceLocation = getFaceLocation(101, 91, 368, 452);
            return faceLocation;
        }
        if(num == 990){
            faceLocation = getFaceLocation(157, 150, 327, 349);
            return faceLocation;
        }
        if(num == 991){
            faceLocation = getFaceLocation(195, 58, 339, 244);
            return faceLocation;
        }
        if(num == 992){
            faceLocation = getFaceLocation(123, 20, 328, 294);
            return faceLocation;
        }
        if(num == 993){
            faceLocation = getFaceLocation(205, 130, 412, 389);
            return faceLocation;
        }
        if(num == 994){
            faceLocation = getFaceLocation(125, 103, 392, 423);
            return faceLocation;
        }
        if(num == 995){
            faceLocation = getFaceLocation(193, 89, 417, 385);
            return faceLocation;
        }
        if(num == 996){
            faceLocation = getFaceLocation(167, 79, 443, 462);
            return faceLocation;
        }
        if(num == 997){
            faceLocation = getFaceLocation(253, 46, 386, 217);
            return faceLocation;
        }
        if(num == 998){
            faceLocation = getFaceLocation(245, 119, 427, 371);
            return faceLocation;
        }
        if(num == 999){
            faceLocation = getFaceLocation(419, 123, 531, 277);
            return faceLocation;
        }
        if(num == 1000){
            faceLocation = getFaceLocation(290, 40, 614, 476);
            return faceLocation;
        }
        if(num == 1001){
            faceLocation = getFaceLocation(156, 126, 436, 449);
            return faceLocation;
        }
        if(num == 1002){
            faceLocation = getFaceLocation(141, 86, 315, 303);
            return faceLocation;
        }
        if(num == 1003){
            faceLocation = getFaceLocation(251, 119, 374, 270);
            return faceLocation;
        }
        if(num == 1004){
            faceLocation = getFaceLocation(241, 131, 519, 431);
            return faceLocation;
        }
        if(num == 1005){
            faceLocation = getFaceLocation(203, 43, 357, 240);
            return faceLocation;
        }
        if(num == 1006){
            faceLocation = getFaceLocation(301, 66, 512, 362);
            return faceLocation;
        }
        if(num == 1007){
            faceLocation = getFaceLocation(80, 93, 365, 421);
            return faceLocation;
        }
        if(num == 1008){
            faceLocation = getFaceLocation(73, 107, 322, 449);
            return faceLocation;
        }
        if(num == 1009){
            faceLocation = getFaceLocation(217, 105, 492, 466);
            return faceLocation;
        }
        if(num == 1010){
            faceLocation = getFaceLocation(69, 68, 329, 409);
            return faceLocation;
        }
        
        throw new Exception("tagging");
    }
    
    private static Integer[] setLalG(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if(num == 881){
            faceLocation = getFaceLocation(253, 97, 526, 392);
            return faceLocation;
        }
        if(num == 882){
            faceLocation = getFaceLocation(390, 226, 535, 407);
            return faceLocation;
        }
        if(num == 883){
            faceLocation = getFaceLocation(34, 120, 316, 447);
            return faceLocation;
        }
        if(num == 884){
            faceLocation = getFaceLocation(159, 67, 534, 463);
            return faceLocation;
        }

        throw new Exception("tagging");
    }
    
    private static Integer[] setKhaS(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if(num == 869){
            faceLocation = getFaceLocation(183, 101, 466, 471);
            return faceLocation;
        }
        if(num == 870){
            faceLocation = getFaceLocation(179, 50, 455, 429);
            return faceLocation;
        }
        if(num == 871){
            faceLocation = getFaceLocation(39, 34, 277, 374);
            return faceLocation;
        }
        if(num == 872){
            faceLocation = getFaceLocation(177, 41, 494, 471);
            return faceLocation;
        }
        if(num == 873){
            faceLocation = getFaceLocation(180, 14, 536, 465);
            return faceLocation;
        }
        if(num == 874){
            faceLocation = getFaceLocation(272, 73, 486, 352);
            return faceLocation;
        }
        if(num == 875){
            faceLocation = getFaceLocation(221, 63, 459, 411);
            return faceLocation;
        }
        if(num == 876){
            faceLocation = getFaceLocation(239, 31, 536, 465);
            return faceLocation;
        }
        if(num == 877){
            faceLocation = getFaceLocation(150, 29, 259, 169);
            return faceLocation;
        }
        if(num == 878){
            faceLocation = getFaceLocation(28, 33, 316, 368);
            return faceLocation;
        }
        if(num == 879){
            faceLocation = getFaceLocation(4, 58, 207, 358);
            return faceLocation;
        }
        if(num == 880){
            faceLocation = getFaceLocation(84, 47, 469, 475);
            return faceLocation;
        }

        throw new Exception("tagging");
    }
    
    private static Integer[] setKarH(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if(num == 862){
            faceLocation = getFaceLocation(219, 56, 450, 359);
            return faceLocation;
        }
        if(num == 863){
            faceLocation = getFaceLocation(240, 80, 460, 349);
            return faceLocation;
        }
        if(num == 864){
            faceLocation = getFaceLocation(251, 92, 468, 341);
            return faceLocation;
        }
        if(num == 865){
            faceLocation = getFaceLocation(275, 66, 497, 339);
            return faceLocation;
        }
        if(num == 866){
            faceLocation = getFaceLocation(272, 83, 522, 392);
            return faceLocation;
        }
        if(num == 867){
            faceLocation = getFaceLocation(272, 106, 498, 395);
            return faceLocation;
        }
        if(num == 868){
            faceLocation = getFaceLocation(220, 87, 445, 378);
            return faceLocation;
        }

        
        throw new Exception("tagging");
    }
    
    private static Integer[] setHbisJ(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if(num == 848){
            faceLocation = getFaceLocation(177, 72, 461, 435);
            return faceLocation;
        }
        if(num == 849){
            faceLocation = getFaceLocation(193, 64, 475, 428);
            return faceLocation;
        }
        if(num == 850){
            faceLocation = getFaceLocation(165, 43, 446, 411);
            return faceLocation;
        }
        if(num == 851){
            faceLocation = getFaceLocation(163, 15, 440, 350);
            return faceLocation;
        }
        if(num == 852){
            faceLocation = getFaceLocation(102, 61, 370, 441);
            return faceLocation;
        }
        if(num == 853){
            faceLocation = getFaceLocation(200, 74, 480, 465);
            return faceLocation;
        }
        if(num == 854){
            faceLocation = getFaceLocation(176, 54, 449, 435);
            return faceLocation;
        }
        if(num == 855){
            faceLocation = getFaceLocation(152, 58, 416, 435);
            return faceLocation;
        }
        if(num == 856){
            faceLocation = getFaceLocation(152, 79, 402, 440);
            return faceLocation;
        }
        if(num == 857){
            faceLocation = getFaceLocation(207, 34, 448, 388);
            return faceLocation;
        }
        if(num == 858){
            faceLocation = getFaceLocation(217, 57, 438, 395);
            return faceLocation;
        }
        if(num == 859){
            faceLocation = getFaceLocation(194, 47, 416, 377);
            return faceLocation;
        }
        if(num == 860){
            faceLocation = getFaceLocation(197, 55, 426, 399);
            return faceLocation;
        }
        if(num == 861){
            faceLocation = getFaceLocation(345, 259, 431, 360);
            return faceLocation;
        }

        throw new Exception("tagging");
    }
    
    private static Integer[] setHitE(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if(num == 846){
            faceLocation = getFaceLocation(43, 80, 339, 417);
            return faceLocation;
        }
        if(num == 847){
            faceLocation = getFaceLocation(129, 74, 478, 470);
            return faceLocation;
        }
        
        throw new Exception("tagging");
    }
    
    private static Integer[] setHad(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if(num == 813){
            faceLocation = getFaceLocation(57, 67, 296, 404);
            return faceLocation;
        }
        if(num == 814){
            faceLocation = getFaceLocation(125, 72, 355, 403);
            return faceLocation;
        }
        if(num == 815){
            faceLocation = getFaceLocation(399, 95, 625, 391);
            return faceLocation;
        }
        if(num == 816){
            faceLocation = getFaceLocation(137, 106, 373, 414);
            return faceLocation;
        }
        if(num == 817){
            faceLocation = getFaceLocation(389, 69, 545, 306);
            return faceLocation;
        }
        if(num == 818){
            faceLocation = getFaceLocation(218, 144, 474, 461);
            return faceLocation;
        }
        if(num == 819){
            faceLocation = getFaceLocation(217, 118, 432, 422);
            return faceLocation;
        }
        if(num == 820){
            faceLocation = getFaceLocation(381, 122, 607, 403);
            return faceLocation;
        }
        if(num == 821){
            faceLocation = getFaceLocation(118, 17, 338, 328);
            return faceLocation;
        }
        if(num == 822){
            faceLocation = getFaceLocation(245, 63, 514, 430);
            return faceLocation;
        }
        if(num == 823){
            faceLocation = getFaceLocation(351, 160, 477, 317);
            return faceLocation;
        }
        if(num == 824){
            faceLocation = getFaceLocation(209, 64, 451, 359);
            return faceLocation;
        }
        if(num == 825){
            faceLocation = getFaceLocation(259, 82, 490, 369);
            return faceLocation;
        }
        if(num == 826){
            faceLocation = getFaceLocation(275, 224, 458, 470);
            return faceLocation;
        }
        if(num == 827){
            faceLocation = getFaceLocation(473, 139, 565, 250);
            return faceLocation;
        }
        if(num == 828){
            faceLocation = getFaceLocation(471, 160, 554, 257);
            return faceLocation;
        }
        if(num == 829){
            faceLocation = getFaceLocation(199, 112, 376, 348);
            return faceLocation;
        }
        if(num == 830){
            faceLocation = getFaceLocation(230, 133, 420, 380);
            return faceLocation;
        }
        if(num == 831){
            faceLocation = getFaceLocation(286, 227, 362, 222);
            return faceLocation;
        }
        if(num == 832){
            faceLocation = getFaceLocation(112, 123, 305, 391);
            return faceLocation;
        }
        if(num == 833){
            faceLocation = getFaceLocation(218, 191, 380, 398);
            return faceLocation;
        }
        if(num == 834){
            faceLocation = getFaceLocation(240, 280, 312, 379);
            return faceLocation;
        }
        if(num == 835){
            faceLocation = getFaceLocation(277, 315, 347, 404);
            return faceLocation;
        }
        if(num == 836){
            faceLocation = getFaceLocation(205, 182, 371, 394);
            return faceLocation;
        }
        if(num == 837){
            faceLocation = getFaceLocation(217, 119, 425, 381);
            return faceLocation;
        }
        if(num == 838){
            faceLocation = getFaceLocation(428, 260, 536, 410);
            return faceLocation;
        }
        if(num == 839){
            faceLocation = getFaceLocation(184, 122, 431, 437);
            return faceLocation;
        }
        if(num == 840){
            faceLocation = getFaceLocation(176, 171, 334, 382);
            return faceLocation;
        }
        if(num == 841){
            faceLocation = getFaceLocation(202, 158, 361, 357);
            return faceLocation;
        }
        if(num == 842){
            faceLocation = getFaceLocation(196, 4, 430, 295);
            return faceLocation;
        }
        if(num == 843){
            faceLocation = getFaceLocation(64, 45, 288, 350);
            return faceLocation;
        }
        if(num == 844){
            faceLocation = getFaceLocation(167, 76, 480, 455);
            return faceLocation;
        }
        if(num == 845){
            faceLocation = getFaceLocation(113, 63, 382, 427);
            return faceLocation;
        }

        throw new Exception("tagging");
    }
    
    private static Integer[] setGeoSGhaN(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if(num == 777){
            faceLocation = getFaceLocation(146, 79, 437, 455);
            return faceLocation;
        }
        if(num == 778){
            faceLocation = getFaceLocation(176, 77, 473, 459);
            return faceLocation;
        }
        if(num == 779){
            faceLocation = getFaceLocation(138, 63, 443, 451);
            return faceLocation;
        }
        if(num == 780){
            faceLocation = getFaceLocation(111, 48, 423, 443);
            return faceLocation;
        }
        if(num == 781){
            faceLocation = getFaceLocation(128, 62, 454, 466);
            return faceLocation;
        }
        if(num == 782){
            faceLocation = getFaceLocation(108, 57, 423, 457);
            return faceLocation;
        }
        if(num == 783){
            faceLocation = getFaceLocation(143, 72, 448, 454);
            return faceLocation;
        }
        if(num == 784){
            faceLocation = getFaceLocation(171, 59, 492, 442);
            return faceLocation;
        }
        if(num == 785){
            faceLocation = getFaceLocation(129, 50, 434, 439);
            return faceLocation;
        }
        if(num == 786){
            faceLocation = getFaceLocation(122, 92, 432, 463);
            return faceLocation;
        }
        if(num == 787){
            faceLocation = getFaceLocation(139, 73, 430, 464);
            return faceLocation;
        }
        if(num == 788){
            faceLocation = getFaceLocation(98, 50, 423, 463);
            return faceLocation;
        }
        if(num == 789){
            faceLocation = getFaceLocation(96, 93, 416, 468);
            return faceLocation;
        }
        if(num == 790){
            faceLocation = getFaceLocation(121, 47, 448, 455);
            return faceLocation;
        }
        if(num == 791){
            faceLocation = getFaceLocation(140, 87, 447, 455);
            return faceLocation;
        }
        if(num == 792){
            faceLocation = getFaceLocation(161, 63, 476, 472);
            return faceLocation;
        }
        if(num == 793){
            faceLocation = getFaceLocation(103, 47, 400, 438);
            return faceLocation;
        }
        if(num == 794){
            faceLocation = getFaceLocation(113, 71, 412, 451);
            return faceLocation;
        }
        if(num == 795){
            faceLocation = getFaceLocation(150, 64, 445, 448);
            return faceLocation;
        }
        if(num == 796){
            faceLocation = getFaceLocation(111, 40, 413, 437);
            return faceLocation;
        }
        if(num == 797){
            faceLocation = getFaceLocation(121, 53, 440, 455);
            return faceLocation;
        }
        if(num == 798){
            faceLocation = getFaceLocation(105, 53, 413, 459);
            return faceLocation;
        }
        if(num == 799){
            faceLocation = getFaceLocation(149, 50, 471, 442);
            return faceLocation;
        }
        if(num == 800){
            faceLocation = getFaceLocation(183, 58, 488, 442);
            return faceLocation;
        }
        if(num == 801){
            faceLocation = getFaceLocation(138, 59, 447, 441);
            return faceLocation;
        }
        if(num == 802){
            faceLocation = getFaceLocation(168, 58, 465, 452);
            return faceLocation;
        }
        if(num == 803){
            faceLocation = getFaceLocation(180, 33, 482, 428);
            return faceLocation;
        }
        if(num == 804){
            faceLocation = getFaceLocation(119, 56, 444, 451);
            return faceLocation;
        }
        if(num == 805){
            faceLocation = getFaceLocation(165, 29, 478, 443);
            return faceLocation;
        }
        if(num == 806){
            faceLocation = getFaceLocation(206, 57, 516, 438);
            return faceLocation;
        }
        if(num == 807){
            faceLocation = getFaceLocation(121, 60, 428, 465);
            return faceLocation;
        }
        if(num == 808){
            faceLocation = getFaceLocation(164, 77, 452, 444);
            return faceLocation;
        }
        if(num == 809){
            faceLocation = getFaceLocation(204, 59, 456, 415);
            return faceLocation;
        }
        if(num == 810){
            faceLocation = getFaceLocation(243, 81, 490, 421);
            return faceLocation;
        }
        if(num == 811){
            faceLocation = getFaceLocation(123, 57, 386, 418);
            return faceLocation;
        }
        if(num == 812){
            faceLocation = getFaceLocation(184, 58, 438, 409);
            return faceLocation;
        }

        throw new Exception("tagging");
    }
    
    private static Integer[] setErbKGamSGawl(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if(num == 747){
            faceLocation = getFaceLocation(211, 108, 446, 418);
            return faceLocation;
        }
        if(num == 748){
            faceLocation = getFaceLocation(90, 90, 298, 393);
            return faceLocation;
        }
        if(num == 749){
            faceLocation = getFaceLocation(87, 61, 345, 432);
            return faceLocation;
        }
        if(num == 750){
            faceLocation = getFaceLocation(97, 113, 323, 415);
            return faceLocation;
        }
        if(num == 751){
            faceLocation = getFaceLocation(319, 170, 485, 398);
            return faceLocation;
        }
        if(num == 752){
            faceLocation = getFaceLocation(492, 281, 591, 416);
            return faceLocation;
        }
        if(num == 753){
            faceLocation = getFaceLocation(240, 285, 351, 427);
            return faceLocation;
        }
        if(num == 754){
            faceLocation = getFaceLocation(327, 283, 416, 390);
            return faceLocation;
        }
        if(num == 755){
            faceLocation = getFaceLocation(327, 73, 403, 163);
            return faceLocation;
        }
        if(num == 756){
            faceLocation = getFaceLocation(321, 6, 594, 395);
            return faceLocation;
        }
        if(num == 757){
            faceLocation = getFaceLocation(42, 71, 175, 245);
            return faceLocation;
        }
        if(num == 758){
            faceLocation = getFaceLocation(286, 63, 559, 451);
            return faceLocation;
        }
        if(num == 759){
            faceLocation = getFaceLocation(262, 71, 412, 268);
            return faceLocation;
        }
        if(num == 760){
            faceLocation = getFaceLocation(48, 74, 160, 222);
            return faceLocation;
        }
        if(num == 761){
            faceLocation = getFaceLocation(231, 53, 470, 377);
            return faceLocation;
        }
        if(num == 762){
            faceLocation = getFaceLocation(177, 69, 435, 386);
            return faceLocation;
        }
        if(num == 763){
            faceLocation = getFaceLocation(333, 133, 563, 442);
            return faceLocation;
        }
        if(num == 764){
            faceLocation = getFaceLocation(98, 43, 406, 473);
            return faceLocation;
        }
        if(num == 765){
            faceLocation = getFaceLocation(137, 51, 380, 363);
            return faceLocation;
        }
        if(num == 766){
            faceLocation = getFaceLocation(182, 39, 426, 373);
            return faceLocation;
        }
        if(num == 767){
            faceLocation = getFaceLocation(166, 65, 430, 390);
            return faceLocation;
        }
        if(num == 768){
            faceLocation = getFaceLocation(161, 57, 426, 456);
            return faceLocation;
        }
        if(num == 769){
            faceLocation = getFaceLocation(219, 78, 428, 363);
            return faceLocation;
        }
        if(num == 770){
            faceLocation = getFaceLocation(50, 54, 283, 358);
            return faceLocation;
        }
        if(num == 771){
            faceLocation = getFaceLocation(207, 45, 504, 475);
            return faceLocation;
        }
        if(num == 772){
            faceLocation = getFaceLocation(172, 56, 362, 331);
            return faceLocation;
        }
        if(num == 773){
            faceLocation = getFaceLocation(192, 74, 420, 383);
            return faceLocation;
        }
        if(num == 774){
            faceLocation = getFaceLocation(29, 52, 278, 374);
            return faceLocation;
        }
        if(num == 775){
            faceLocation = getFaceLocation(161, 79, 334, 329);
            return faceLocation;
        }
        if(num == 776){
            faceLocation = getFaceLocation(167, 95, 348, 326);
            return faceLocation;
        }

        
        throw new Exception("tagging");
    }
    
    private static Integer[] setDoaB(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if(num == 744){
            faceLocation = getFaceLocation(366, 118, 575, 398);
            return faceLocation;
        }
        if(num == 745){
            faceLocation = getFaceLocation(350, 27, 612, 388);
            return faceLocation;
        }
        if(num == 746){
            faceLocation = getFaceLocation(343, 160, 518, 386);
            return faceLocation;
        }
        
        throw new Exception("tagging");
    }
    
    private static Integer[] setBonG(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if(num == 742){
            faceLocation = getFaceLocation(233, 71, 495, 436);
            return faceLocation;
        }
        if(num == 743){
            faceLocation = getFaceLocation(173, 51, 465, 434);
            return faceLocation;
        }
        throw new Exception("tagging");
    }
    
    private static Integer[] setBes(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if(num == 730){
            faceLocation = getFaceLocation(210, 82, 402, 301);
            return faceLocation;
        }
        if(num == 731){
            faceLocation = getFaceLocation(159, 56, 344, 280);
            return faceLocation;
        }
        if(num == 732){
            faceLocation = getFaceLocation(197, 57, 397, 314);
            return faceLocation;
        }
        if(num == 733){
            faceLocation = getFaceLocation(254, 60, 440, 296);
            return faceLocation;
        }
        if(num == 734){
            faceLocation = getFaceLocation(231, 55, 382, 244);
            return faceLocation;
        }
        if(num == 735){
            faceLocation = getFaceLocation(257, 82, 430, 297);
            return faceLocation;
        }
        if(num == 736){
            faceLocation = getFaceLocation(222, 68, 389, 268);
            return faceLocation;
        }
        if(num == 737){
            faceLocation = getFaceLocation(228, 66, 400, 272);
            return faceLocation;
        }
        if(num == 738){
            faceLocation = getFaceLocation(212, 37, 449, 363);
            return faceLocation;
        }
        if(num == 739){
            faceLocation = getFaceLocation(189, 75, 405, 388);
            return faceLocation;
        }
        if(num == 740){
            faceLocation = getFaceLocation(262, 68, 478, 379);
            return faceLocation;
        }
        if(num == 741){
            faceLocation = getFaceLocation(209, 63, 450, 419);
            return faceLocation;
        }

        throw new Exception("tagging");
    }
    
    private static Integer[] setBelA(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;

        if(num == 722){
            faceLocation = getFaceLocation(292, 78, 561, 453);
            return faceLocation;
        }
        if(num == 723){
            faceLocation = getFaceLocation(126, 64, 365, 433);
            return faceLocation;
        }
        if(num == 724){
            faceLocation = getFaceLocation(210, 54, 439, 368);
            return faceLocation;
        }
        if(num == 725){
            faceLocation = getFaceLocation(167, 38, 427, 407);
            return faceLocation;
        }
        if(num == 726){
            faceLocation = getFaceLocation(160, 77, 415, 416);
            return faceLocation;
        }
        if(num == 727){
            faceLocation = getFaceLocation(154, 50, 403, 427);
            return faceLocation;
        }
        if(num == 728){
            faceLocation = getFaceLocation(131, 61, 388, 395);
            return faceLocation;
        }
        if(num == 729){
            faceLocation = getFaceLocation(153, 67, 416, 435);
            return faceLocation;
        }

        throw new Exception("tagging");
    }
    
    private static Integer[] setBahA(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if(num >= 575 && num <= 579){
            faceLocation = getFaceLocation(230, 100, 361, 283);
            return faceLocation;
        }
        if(num >= 580 && num <= 721){
            faceLocation = getFaceLocation(227, 106, 374, 285);
            return faceLocation;
        }
        throw new Exception("tagging");
    }

    private static Integer[] setAymK(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if (num == 570) {
            faceLocation = getFaceLocation(197, 45, 417, 365);
            return faceLocation;
        }
        if (num == 571) {
            faceLocation = getFaceLocation(268, 29, 415, 217);
            return faceLocation;
        }
        if (num == 572) {
            faceLocation = getFaceLocation(251, 29, 496, 380);
            return faceLocation;
        }
        if (num == 573) {
            faceLocation = getFaceLocation(315, 27, 606, 457);
            return faceLocation;
        }
        if (num == 574) {
            faceLocation = getFaceLocation(137, 22, 427, 445);
            return faceLocation;
        }
        throw new Exception("tagging");
    }

    private static Integer[] setAshSAsmH(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if (num == 538) {
            faceLocation = getFaceLocation(36, 7, 329, 375);
            return faceLocation;
        }
        if (num == 539) {
            faceLocation = getFaceLocation(51, 7, 347, 371);
            return faceLocation;
        }
        if (num == 540) {
            faceLocation = getFaceLocation(113, 70, 386, 423);
            return faceLocation;
        }
        if (num == 541) {
            faceLocation = getFaceLocation(3, 18, 329, 404);
            return faceLocation;
        }
        if (num == 542) {
            faceLocation = getFaceLocation(91, 64, 364, 450);
            return faceLocation;
        }
        if (num == 543) {
            faceLocation = getFaceLocation(203, 71, 468, 455);
            return faceLocation;
        }
        if (num == 544) {
            faceLocation = getFaceLocation(158, 97, 405, 433);
            return faceLocation;
        }
        if (num == 545) {
            faceLocation = getFaceLocation(180, 38, 444, 434);
            return faceLocation;
        }
        if (num == 546) {
            faceLocation = getFaceLocation(199, 74, 462, 471);
            return faceLocation;
        }
        if (num == 547) {
            faceLocation = getFaceLocation(84, 23, 396, 460);
            return faceLocation;
        }
        if (num == 548) {
            faceLocation = getFaceLocation(289, 32, 613, 449);
            return faceLocation;
        }
        if (num == 549) {
            faceLocation = getFaceLocation(24, 113, 395, 469);
            return faceLocation;
        }
        if (num == 550) {
            faceLocation = getFaceLocation(4, 32, 225, 404);
            return faceLocation;
        }
        if (num == 551) {
            faceLocation = getFaceLocation(35, 16, 232, 295);
            return faceLocation;
        }
        if (num == 552) {
            faceLocation = getFaceLocation(92, 6, 449, 472);
            return faceLocation;
        }
        if (num == 553) {
            faceLocation = getFaceLocation(40, 25, 334, 426);
            return faceLocation;
        }
        if (num == 554) {
            faceLocation = getFaceLocation(146, 64, 428, 418);
            return faceLocation;
        }
        if (num == 555) {
            faceLocation = getFaceLocation(131, 49, 432, 447);
            return faceLocation;
        }
        if (num == 556) {
            faceLocation = getFaceLocation(6, 36, 188, 275);
            return faceLocation;
        }
        if (num == 557) {
            faceLocation = getFaceLocation(216, 47, 476, 423);
            return faceLocation;
        }
        if (num == 558) {
            faceLocation = getFaceLocation(373, 78, 606, 403);
            return faceLocation;
        }
        if (num == 559) {
            faceLocation = getFaceLocation(45, 8, 233, 295);
            return faceLocation;
        }
        if (num == 560) {
            faceLocation = getFaceLocation(382, 81, 633, 461);
            return faceLocation;
        }
        if (num == 561) {
            faceLocation = getFaceLocation(285, 36, 630, 398);
            return faceLocation;
        }
        if (num == 562) {
            faceLocation = getFaceLocation(267, 29, 582, 442);
            return faceLocation;
        }
        if (num == 563) {
            faceLocation = getFaceLocation(279, 75, 568, 452);
            return faceLocation;
        }
        if (num == 564) {
            faceLocation = getFaceLocation(42, 12, 329, 339);
            return faceLocation;
        }
        if (num == 565) {
            faceLocation = getFaceLocation(269, 30, 538, 421);
            return faceLocation;
        }
        if (num == 566) {
            faceLocation = getFaceLocation(263, 7, 585, 378);
            return faceLocation;
        }
        if (num == 567) {
            faceLocation = getFaceLocation(143, 3, 556, 439);
            return faceLocation;
        }
        if (num == 568) {
            faceLocation = getFaceLocation(7, 79, 206, 280);
            return faceLocation;
        }
        if (num == 569) {
            faceLocation = getFaceLocation(421, 28, 598, 320);
            return faceLocation;
        }
        throw new Exception("tagging");
    }

    private static Integer[] setAndP(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;
        if (num == 530) {
            faceLocation = getFaceLocation(248, 52, 525, 465);
            return faceLocation;
        }
        if (num == 531) {
            faceLocation = getFaceLocation(193, 80, 444, 434);
            return faceLocation;
        }
        if (num == 532) {
            faceLocation = getFaceLocation(157, 63, 438, 447);
            return faceLocation;
        }
        if (num == 533) {
            faceLocation = getFaceLocation(206, 69, 452, 410);
            return faceLocation;
        }
        if (num == 534) {
            faceLocation = getFaceLocation(140, 69, 411, 452);
            return faceLocation;
        }
        if (num == 535) {
            faceLocation = getFaceLocation(171, 92, 429, 432);
            return faceLocation;
        }
        if (num == 536) {
            faceLocation = getFaceLocation(160, 49, 449, 443);
            return faceLocation;
        }
        if (num == 537) {
            faceLocation = getFaceLocation(170, 65, 420, 418);
            return faceLocation;
        }

        throw new Exception("tagging");
    }

    private static Integer[] setAndM(NameInfo imInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imInfo.number;

        if (num == 526) {
            faceLocation = getFaceLocation(140, 6, 579, 473);
            return faceLocation;
        }
        if (num == 527) {
            faceLocation = getFaceLocation(281, 48, 450, 272);
            return faceLocation;
        }
        if (num == 528) {
            faceLocation = getFaceLocation(167, 36, 345, 274);
            return faceLocation;
        }
        if (num == 529) {
            faceLocation = getFaceLocation(234, 79, 404, 280);
            return faceLocation;
        }
        throw new Exception("tagging");
    }

    private static Integer[] setAliy_(NameInfo imgInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imgInfo.number;
        if (num == 503) {
            faceLocation = getFaceLocation(328, 70, 437, 230);
            return faceLocation;
        }
        if (num == 504) {
            faceLocation = getFaceLocation(233, 49, 438, 321);
            return faceLocation;
        }
        if (num == 505) {
            faceLocation = getFaceLocation(96, 36, 393, 441);
            return faceLocation;
        }
        if (num == 506) {
            faceLocation = getFaceLocation(153, 53, 341, 345);
            return faceLocation;
        }
        if (num == 507) {
            faceLocation = getFaceLocation(44, 7, 293, 353);
            return faceLocation;
        }
        if (num == 508) {
            faceLocation = getFaceLocation(359, 47, 531, 298);
            return faceLocation;
        }
        if (num == 509) {
            faceLocation = getFaceLocation(228, 99, 388, 339);
            return faceLocation;
        }
        if (num == 510) {
            faceLocation = getFaceLocation(167, 43, 447, 421);
            return faceLocation;
        }
        if (num == 511) {
            faceLocation = getFaceLocation(207, 25, 496, 410);
            return faceLocation;
        }
        if (num == 512) {
            faceLocation = getFaceLocation(207, 58, 495, 441);
            return faceLocation;
        }
        if (num == 513) {
            faceLocation = getFaceLocation(148, 30, 428, 420);
            return faceLocation;
        }
        if (num == 514) {
            faceLocation = getFaceLocation(222, 29, 497, 407);
            return faceLocation;
        }
        if (num == 515) {
            faceLocation = getFaceLocation(181, 52, 498, 432);
            return faceLocation;
        }
        if (num == 516) {
            faceLocation = getFaceLocation(197, 69, 477, 416);
            return faceLocation;
        }
        if (num == 517) {
            faceLocation = getFaceLocation(218, 66, 495, 456);
            return faceLocation;
        }
        if (num == 518) {
            faceLocation = getFaceLocation(132, 1, 473, 318);
            return faceLocation;
        }
        if (num == 519) {
            faceLocation = getFaceLocation(96, 4, 421, 365);
            return faceLocation;
        }
        if (num == 520) {
            faceLocation = getFaceLocation(249, 1, 570, 362);
            return faceLocation;
        }
        if (num == 521) {
            faceLocation = getFaceLocation(198, 6, 451, 308);
            return faceLocation;
        }
        if (num == 522) {
            faceLocation = getFaceLocation(104, 22, 386, 415);
            return faceLocation;
        }
        if (num == 523) {
            faceLocation = getFaceLocation(210, 2, 531, 318);
            return faceLocation;
        }
        if (num == 524) {
            faceLocation = getFaceLocation(101, 3, 460, 434);
            return faceLocation;
        }
        if (num == 525) {
            faceLocation = getFaceLocation(146, 2, 504, 369);
            return faceLocation;
        }
        throw new Exception("tagging");
    }

    private static Integer[] setAhm_(NameInfo imgInfo) throws Exception {
        Integer[] faceLocation = new Integer[1];
        int num = imgInfo.number;
        if (num == 297) {
            faceLocation = getFaceLocation(202, 31, 467, 440);
            return faceLocation;
        }
        if (num == 298) {
            faceLocation = getFaceLocation(16, 47, 268, 388);
            return faceLocation;
        }
        if (num == 299) {
            faceLocation = getFaceLocation(247, 17, 542, 446);
            return faceLocation;
        }
        if (num == 300) {
            faceLocation = getFaceLocation(167, 57, 363, 355);
            return faceLocation;
        }
        if (num == 301) {
            faceLocation = getFaceLocation(206, 34, 435, 343);
            return faceLocation;
        }
        if (num == 302) {
            faceLocation = getFaceLocation(17, 23, 198, 273);
            return faceLocation;
        }
        if (num == 303) {
            faceLocation = getFaceLocation(258, 58, 516, 420);
            return faceLocation;
        }
        if (num == 304) {
            faceLocation = getFaceLocation(206, 162, 393, 426);
            return faceLocation;
        }
        if (num == 305) {
            faceLocation = getFaceLocation(106, 93, 365, 444);
            return faceLocation;
        }
        if (num == 306) {
            faceLocation = getFaceLocation(132, 65, 351, 329);
            return faceLocation;
        }
        if (num == 307) {
            faceLocation = getFaceLocation(132, 65, 351, 329);
            return faceLocation;
        }
        if (num == 308) {
            faceLocation = getFaceLocation(314, 42, 621, 423);
            return faceLocation;
        }
        if (num == 309) {
            faceLocation = getFaceLocation(201, 155, 357, 385);
            return faceLocation;
        }
        if (num == 310) {
            faceLocation = getFaceLocation(257, 26, 548, 398);
            return faceLocation;
        }
        if (num == 311) {
            faceLocation = getFaceLocation(168, 18, 483, 437);
            return faceLocation;
        }
        if (num == 312) {
            faceLocation = getFaceLocation(172, 26, 384, 294);
            return faceLocation;
        }
        if (num == 313) {
            faceLocation = getFaceLocation(221, 87, 416, 344);
            return faceLocation;
        }
        if (num == 314) {
            faceLocation = getFaceLocation(197, 20, 511, 399);
            return faceLocation;
        }
        if (num == 315) {
            faceLocation = getFaceLocation(162, 53, 460, 441);
            return faceLocation;
        }
        if (num == 316) {
            faceLocation = getFaceLocation(172, 57, 465, 422);
            return faceLocation;
        }
        if (num == 317) {
            faceLocation = getFaceLocation(163, 54, 437, 424);
            return faceLocation;
        }
        if (num == 318) {
            faceLocation = getFaceLocation(142, 50, 440, 452);
            return faceLocation;
        }
        if (num == 319) {
            faceLocation = getFaceLocation(194, 75, 494, 475);
            return faceLocation;
        }
        if (num == 320) {
            faceLocation = getFaceLocation(189, 42, 472, 415);
            return faceLocation;
        }
        if (num == 321) {
            faceLocation = getFaceLocation(165, 30, 465, 436);
            return faceLocation;
        }
        if (num == 322) {
            faceLocation = getFaceLocation(231, 60, 499, 426);
            return faceLocation;
        }
        if (num == 323) {
            faceLocation = getFaceLocation(157, 28, 366, 327);
            return faceLocation;
        }
        if (num == 324) {
            faceLocation = getFaceLocation(170, 46, 361, 319);
            return faceLocation;
        }
        if (num == 325) {
            faceLocation = getFaceLocation(180, 16, 366, 254);
            return faceLocation;
        }
        if (num == 326) {
            faceLocation = getFaceLocation(151, 63, 348, 341);
            return faceLocation;
        }
        if (num == 327) {
            faceLocation = getFaceLocation(290, 89, 411, 261);
            return faceLocation;
        }
        if (num == 328) {
            faceLocation = getFaceLocation(412, 36, 526, 192);
            return faceLocation;
        }
        if (num == 329) {
            faceLocation = getFaceLocation(178, 4, 526, 476);
            return faceLocation;
        }
        if (num == 330) {
            faceLocation = getFaceLocation(56, 91, 263, 407);
            return faceLocation;
        }
        if (num == 331) {
            faceLocation = getFaceLocation(160, 26, 407, 392);
            return faceLocation;
        }
        if (num == 332) {
            faceLocation = getFaceLocation(68, 63, 242, 309);
            return faceLocation;
        }
        if (num == 333) {
            faceLocation = getFaceLocation(206, 33, 487, 423);
            return faceLocation;
        }
        if (num == 334) {
            faceLocation = getFaceLocation(89, 49, 328, 379);
            return faceLocation;
        }
        if (num == 335) {
            faceLocation = getFaceLocation(136, 32, 415, 391);
            return faceLocation;
        }
        if (num == 336) {
            faceLocation = getFaceLocation(171, 60, 408, 349);
            return faceLocation;
        }
        if (num == 337) {
            faceLocation = getFaceLocation(195, 34, 430, 359);
            return faceLocation;
        }
        if (num == 338) {
            faceLocation = getFaceLocation(186, 42, 456, 408);
            return faceLocation;
        }
        if (num == 339) {
            faceLocation = getFaceLocation(238, 20, 510, 392);
            return faceLocation;
        }
        if (num == 340) {
            faceLocation = getFaceLocation(183, 36, 444, 391);
            return faceLocation;
        }
        if (num == 341) {
            faceLocation = getFaceLocation(284, 42, 553, 428);
            return faceLocation;
        }
        if (num == 342) {
            faceLocation = getFaceLocation(316, 45, 582, 414);
            return faceLocation;
        }
        if (num == 343) {
            faceLocation = getFaceLocation(311, 93, 452, 273);
            return faceLocation;
        }
        if (num == 344) {
            faceLocation = getFaceLocation(224, 126, 323, 261);
            return faceLocation;
        }
        if (num == 345) {
            faceLocation = getFaceLocation(384, 170, 472, 282);
            return faceLocation;
        }
        if (num == 346) {
            faceLocation = getFaceLocation(307, 110, 428, 256);
            return faceLocation;
        }
        if (num == 347) {
            faceLocation = getFaceLocation(121, 36, 267, 219);
            return faceLocation;
        }
        if (num == 348) {
            faceLocation = getFaceLocation(269, 59, 404, 239);
            return faceLocation;
        }
        if (num == 349) {
            faceLocation = getFaceLocation(290, 82, 517, 389);
            return faceLocation;
        }
        if (num == 350) {
            faceLocation = getFaceLocation(122, 70, 369, 403);
            return faceLocation;
        }
        if (num == 351) {
            faceLocation = getFaceLocation(207, 28, 498, 411);
            return faceLocation;
        }
        if (num == 352) {
            faceLocation = getFaceLocation(152, 72, 443, 425);
            return faceLocation;
        }
        if (num == 353) {
            faceLocation = getFaceLocation(163, 85, 458, 414);
            return faceLocation;
        }
        if (num == 354) {
            faceLocation = getFaceLocation(222, 44, 504, 389);
            return faceLocation;
        }
        if (num == 355) {
            faceLocation = getFaceLocation(170, 73, 469, 414);
            return faceLocation;
        }
        if (num == 356) {
            faceLocation = getFaceLocation(169, 56, 460, 411);
            return faceLocation;
        }
        if (num == 357) {
            faceLocation = getFaceLocation(195, 80, 503, 413);
            return faceLocation;
        }
        if (num == 358) {
            faceLocation = getFaceLocation(185, 75, 466, 468);
            return faceLocation;
        }
        if (num == 359) {
            faceLocation = getFaceLocation(151, 62, 439, 455);
            return faceLocation;
        }
        if (num == 360) {
            faceLocation = getFaceLocation(146, 57, 454, 466);
            return faceLocation;
        }
        if (num == 361) {
            faceLocation = getFaceLocation(196, 58, 494, 464);
            return faceLocation;
        }
        if (num == 362) {
            faceLocation = getFaceLocation(191, 51, 489, 464);
            return faceLocation;
        }
        if (num == 363) {
            faceLocation = getFaceLocation(173, 66, 466, 463);
            return faceLocation;
        }
        if (num == 364) {
            faceLocation = getFaceLocation(137, 77, 423, 477);
            return faceLocation;
        }
        if (num == 365) {
            faceLocation = getFaceLocation(140, 40, 439, 451);
            return faceLocation;
        }

        throw new Exception("tagging");
    }

    private static Integer[] setAheGtoAheS(NameInfo imgInfo) throws Exception {
        Integer[] faceLocation = new Integer[4];
        int num = imgInfo.number;

        if (num == 288) {
            faceLocation = getFaceLocation(85, 16, 405, 455);
            return faceLocation;
        }
        if (num == 289) {
            faceLocation = getFaceLocation(187, 19, 424, 348);
            return faceLocation;
        }
        if (num == 290) {
            faceLocation = getFaceLocation(390, 60, 526, 348);
            return faceLocation;
        }
        if (num == 291) {
            faceLocation = getFaceLocation(204, 14, 414, 268);
            return faceLocation;
        }
        if (num == 292) {
            faceLocation = getFaceLocation(168, 15, 539, 467);
            return faceLocation;
        }
        if (num == 293) {
            faceLocation = getFaceLocation(371, 248, 477, 375);
            return faceLocation;
        }
        if (num == 294) {
            faceLocation = getFaceLocation(400, 58, 582, 297);
            return faceLocation;
        }
        if (num == 295) {
            faceLocation = getFaceLocation(138, 41, 377, 379);
            return faceLocation;
        }
        if (num == 296) {
            faceLocation = getFaceLocation(191, 28, 461, 427);
            return faceLocation;
        }

        throw new Exception("tagging");
    }

    private static Integer[] setAboA(NameInfo imgInfo) throws Exception {
        Integer[] faceLocation = new Integer[2];
        if (imgInfo.number == 136) {
            faceLocation = getFaceLocation(193, 7, 373, 222);
            return faceLocation;
        }
        if (imgInfo.number == 137 || imgInfo.number == 138) {
            faceLocation = getFaceLocation(190, 6, 374, 238);
            return faceLocation;
        }
        if (imgInfo.number >= 139 && imgInfo.number <= 152) {
            faceLocation = getFaceLocation(202, 13, 383, 244);
            return faceLocation;
        }
        if (imgInfo.number >= 153 && imgInfo.number <= 154) {
            faceLocation = getFaceLocation(214, 18, 390, 224);
            return faceLocation;
        }
        if (imgInfo.number >= 155 && imgInfo.number <= 161) {
            faceLocation = getFaceLocation(215, 20, 405, 247);
            return faceLocation;
        }
        if (imgInfo.number >= 162 && imgInfo.number <= 220) {
            faceLocation = getFaceLocation(225, 132, 410, 363);
            return faceLocation;
        }
        if (imgInfo.number >= 220 && imgInfo.number <= 287) {
            faceLocation = getFaceLocation(246, 133, 441, 360);
            return faceLocation;
        }
        throw new Exception("tagging");
    }

    private static Integer[] setAdbH(NameInfo imgInfo) throws Exception {
        Integer[] faceLocation = new Integer[2];
        if (imgInfo.number == 128) {
            faceLocation = getFaceLocation(210, 81, 408, 353);
            return faceLocation;
        }
        if (imgInfo.number == 129) {
            faceLocation = getFaceLocation(129, 38, 389, 427);
            return faceLocation;
        }
        if (imgInfo.number == 130) {
            faceLocation = getFaceLocation(188, 14, 449, 449);
            return faceLocation;
        }
        if (imgInfo.number == 131) {
            faceLocation = getFaceLocation(186, 19, 454, 431);
            return faceLocation;
        }
        if (imgInfo.number == 132) {
            faceLocation = getFaceLocation(190, 7, 459, 418);
            return faceLocation;
        }
        if (imgInfo.number == 133) {
            faceLocation = getFaceLocation(227, 41, 499, 406);
            return faceLocation;
        }
        if (imgInfo.number == 134) {
            faceLocation = getFaceLocation(219, 19, 493, 470);
            return faceLocation;
        }
        if (imgInfo.number == 135) {
            faceLocation = getFaceLocation(38, 121, 222, 370);
            return faceLocation;
        }
        throw new Exception("tagging");
    }

    private static Integer[] getFaceLocation(int x1, int y1, int x2, int y2) {
        Integer[] arr = {x1, y1, x2, y2};
        return arr;
    }
}
