package com.main.sections;

public class ELOT743Convertor {

	public static String convert(String y) {
		y = y.replace("άι", "áï");
		y = y.replace("Άι", "Áï");
		y = y.replace("άΙ", "áÏ");
		y = y.replace("ΆΙ", "ÁÏ");

		y = y.replace("έι", "éï");
		y = y.replace("Έι", "Éï");
		y = y.replace("έΙ", "éÏ");
		y = y.replace("ΈΙ", "ÉÏ");

		y = y.replace("όι", "óï");
		y = y.replace("Όι", "Óï");
		y = y.replace("όΙ", "óÏ");
		y = y.replace("ΌΙ", "ÓÏ");

		for(Character charact : y.toCharArray()){
			y = y.replace(charact, removegreektones(charact));
		}

		y = y.replace("αυα", "avα");
		y = y.replace("Αυα", "Avα");
		y = y.replace("αΥα", "aVα");
		y = y.replace("αυΑ", "avA");
		y = y.replace("ΑΥα", "AVα");
		y = y.replace("αΥΑ", "aVΑ");
		y = y.replace("ΑυΑ", "AvΑ");
		y = y.replace("ΑΥΑ", "AVΑ");

		y = y.replace("αυβ", "av");
		y = y.replace("Αυβ", "Av");
		y = y.replace("αΥβ", "aV");
		y = y.replace("αυΒ", "aV");
		y = y.replace("ΑΥβ", "AV");
		y = y.replace("αΥΒ", "aV");
		y = y.replace("ΑυΒ", "AV");
		y = y.replace("ΑΥΒ", "AV");

		y = y.replace("αυγ", "avγ");
		y = y.replace("Αυγ", "Avγ");
		y = y.replace("αΥγ", "aVγ");
		y = y.replace("αυΓ", "avΓ");
		y = y.replace("ΑΥγ", "AVγ");
		y = y.replace("αΥΓ", "aVΓ");
		y = y.replace("ΑυΓ", "AvΓ");
		y = y.replace("ΑΥΓ", "AVΓ");

		y = y.replace("αυδ", "avδ");
		y = y.replace("Αυδ", "Avδ");
		y = y.replace("αΥδ", "aVδ");
		y = y.replace("αυΔ", "avΔ");
		y = y.replace("ΑΥδ", "AVδ");
		y = y.replace("αΥΔ", "aVΔ");
		y = y.replace("ΑυΔ", "AvΔ");
		y = y.replace("ΑΥΔ", "AVΔ");

		y = y.replace("αυε", "avε");
		y = y.replace("Αυε", "Avε");
		y = y.replace("αΥε", "aVε");
		y = y.replace("αυΕ", "avΕ");
		y = y.replace("ΑΥε", "AVε");
		y = y.replace("αΥΕ", "aVΕ");
		y = y.replace("ΑυΕ", "AvΕ");
		y = y.replace("ΑΥΕ", "AVΕ");

		y = y.replace("αυζ", "avζ");
		y = y.replace("Αυζ", "Avζ");
		y = y.replace("αΥζ", "aVζ");
		y = y.replace("αυΖ", "avΖ");
		y = y.replace("ΑΥζ", "AVζ");
		y = y.replace("αΥΖ", "aVΖ");
		y = y.replace("ΑυΖ", "AvΖ");
		y = y.replace("ΑΥΖ", "AVΖ");

		y = y.replace("αυη", "avη");
		y = y.replace("Αυη", "Avη");
		y = y.replace("αΥη", "aVη");
		y = y.replace("αυΗ", "avΗ");
		y = y.replace("ΑΥη", "AVη");
		y = y.replace("αΥΗ", "aVΗ");
		y = y.replace("ΑυΗ", "AvΗ");
		y = y.replace("ΑΥΗ", "AVΗ");

		y = y.replace("αυθ", "afθ");
		y = y.replace("Αυθ", "Afθ");
		y = y.replace("αΥθ", "aFθ");
		y = y.replace("αυΘ", "afΘ");
		y = y.replace("ΑΥθ", "AFθ");
		y = y.replace("αΥΘ", "aFΘ");
		y = y.replace("ΑυΘ", "AfΘ");
		y = y.replace("ΑΥΘ", "AFΘ");

		y = y.replace("αυι", "avι");
		y = y.replace("Αυι", "Avι");
		y = y.replace("αΥι", "aVι");
		y = y.replace("αυΙ", "avΙ");
		y = y.replace("ΑΥι", "AVι");
		y = y.replace("αΥΙ", "aVΙ");
		y = y.replace("ΑυΙ", "AvΙ");
		y = y.replace("ΑΥΙ", "AVΙ");

		y = y.replace("αυκ", "afκ");
		y = y.replace("Αυκ", "Afκ");
		y = y.replace("αΥκ", "aFκ");
		y = y.replace("αυΚ", "afΚ");
		y = y.replace("ΑΥκ", "AFκ");
		y = y.replace("αΥΚ", "aFΚ");
		y = y.replace("ΑυΚ", "AfΚ");
		y = y.replace("ΑΥΚ", "AFΚ");

		y = y.replace("αυλ", "avλ");
		y = y.replace("Αυλ", "Avλ");
		y = y.replace("αΥλ", "aVλ");
		y = y.replace("αυΛ", "avΛ");
		y = y.replace("ΑΥλ", "AVλ");
		y = y.replace("αΥΛ", "aVΛ");
		y = y.replace("ΑυΛ", "AvΛ");
		y = y.replace("ΑΥΛ", "AVΛ");

		y = y.replace("αυμ", "avμ");
		y = y.replace("Αυμ", "Avμ");
		y = y.replace("αΥμ", "aVμ");
		y = y.replace("αυΜ", "avΜ");
		y = y.replace("ΑΥμ", "AVμ");
		y = y.replace("αΥΜ", "aVΜ");
		y = y.replace("ΑυΜ", "AvΜ");
		y = y.replace("ΑΥΜ", "AVΜ");

		y = y.replace("αυν", "avν");
		y = y.replace("Αυν", "Avν");
		y = y.replace("αΥν", "aVν");
		y = y.replace("αυΝ", "avΝ");
		y = y.replace("ΑΥν", "AVν");
		y = y.replace("αΥΝ", "aVΝ");
		y = y.replace("ΑυΝ", "AvΝ");
		y = y.replace("ΑΥΝ", "AVΝ");

		y = y.replace("αυξ", "afξ");
		y = y.replace("Αυξ", "Afξ");
		y = y.replace("αΥξ", "aFξ");
		y = y.replace("αυΞ", "afΞ");
		y = y.replace("ΑΥξ", "AFξ");
		y = y.replace("αΥΞ", "aFΞ");
		y = y.replace("ΑυΞ", "AfΞ");
		y = y.replace("ΑΥΞ", "AFΞ");

		y = y.replace("αυο", "avο");
		y = y.replace("Αυο", "Avο");
		y = y.replace("αΥο", "aVο");
		y = y.replace("αυΟ", "avΟ");
		y = y.replace("ΑΥο", "AVο");
		y = y.replace("αΥΟ", "aVΟ");
		y = y.replace("ΑυΟ", "AvΟ");
		y = y.replace("ΑΥΟ", "AVΟ");

		y = y.replace("αυπ", "afπ");
		y = y.replace("Αυπ", "Afπ");
		y = y.replace("αΥπ", "aFπ");
		y = y.replace("αυΠ", "afΠ");
		y = y.replace("ΑΥπ", "AFπ");
		y = y.replace("αΥΠ", "aFΠ");
		y = y.replace("ΑυΠ", "AfΠ");
		y = y.replace("ΑΥΠ", "AFΠ");

		y = y.replace("αυρ", "avρ");
		y = y.replace("Αυρ", "Avρ");
		y = y.replace("αΥρ", "aVρ");
		y = y.replace("αυΡ", "avΡ");
		y = y.replace("ΑΥρ", "AVρ");
		y = y.replace("αΥΡ", "aVΡ");
		y = y.replace("ΑυΡ", "AvΡ");
		y = y.replace("ΑΥΡ", "AVΡ");

		y = y.replace("αυσ", "afσ");
		y = y.replace("Αυσ", "Afσ");
		y = y.replace("αΥσ", "aFσ");
		y = y.replace("αυΣ", "afΣ");
		y = y.replace("ΑΥσ", "AFσ");
		y = y.replace("αΥΣ", "aFΣ");
		y = y.replace("ΑυΣ", "AfΣ");
		y = y.replace("ΑΥΣ", "AFΣ");
		y = y.replace("αυς", "afς");
		y = y.replace("Αυς", "Afς");
		y = y.replace("αΥς", "aFς");
		y = y.replace("ΑΥς", "AFς");

		y = y.replace("αυτ", "afτ");
		y = y.replace("Αυτ", "Afτ");
		y = y.replace("αΥτ", "aFτ");
		y = y.replace("αυΤ", "afΤ");
		y = y.replace("ΑΥτ", "AFτ");
		y = y.replace("αΥΤ", "aFΤ");
		y = y.replace("ΑυΤ", "AfΤ");
		y = y.replace("ΑΥΤ", "AFΤ");

		y = y.replace("αυφ", "af");
		y = y.replace("Αυφ", "Af");
		y = y.replace("αΥφ", "aF");
		y = y.replace("αυΦ", "aF");
		y = y.replace("ΑΥφ", "AF");
		y = y.replace("αΥΦ", "aF");
		y = y.replace("ΑυΦ", "AF");
		y = y.replace("ΑΥΦ", "AF");

		y = y.replace("αυχ", "afχ");
		y = y.replace("Αυχ", "Afχ");
		y = y.replace("αΥχ", "aFχ");
		y = y.replace("αυΧ", "afΧ");
		y = y.replace("ΑΥχ", "AFχ");
		y = y.replace("αΥΧ", "aFΧ");
		y = y.replace("ΑυΧ", "AfΧ");
		y = y.replace("ΑΥΧ", "AFΧ");

		y = y.replace("αυψ", "afψ");
		y = y.replace("Αυψ", "Afψ");
		y = y.replace("αΥψ", "aFψ");
		y = y.replace("αυΨ", "afΨ");
		y = y.replace("ΑΥψ", "AFψ");
		y = y.replace("αΥΨ", "aFΨ");
		y = y.replace("ΑυΨ", "AfΨ");
		y = y.replace("ΑΥΨ", "AFΨ");

		y = y.replace("αυω", "avω");
		y = y.replace("Αυω", "Avω");
		y = y.replace("αΥω", "aVω");
		y = y.replace("αυΩ", "avΩ");
		y = y.replace("ΑΥω", "AVω");
		y = y.replace("αΥΩ", "aVΩ");
		y = y.replace("ΑυΩ", "AvΩ");
		y = y.replace("ΑΥΩ", "AVΩ");
		y = y.replace("ευα", "evα");
		y = y.replace("Ευα", "Evα");
		y = y.replace("εΥα", "eVα");
		y = y.replace("ευΑ", "evA");
		y = y.replace("ΕΥα", "EVα");
		y = y.replace("εΥΑ", "eVΑ");
		y = y.replace("ΕυΑ", "EvΑ");
		y = y.replace("ΕΥΑ", "EVΑ");

		y = y.replace("ευβ", "ev");
		y = y.replace("Ευβ", "Ev");
		y = y.replace("εΥβ", "eV");
		y = y.replace("ευΒ", "eV");
		y = y.replace("ΕΥβ", "EV");
		y = y.replace("εΥΒ", "eV");
		y = y.replace("ΕυΒ", "EV");
		y = y.replace("ΕΥΒ", "EV");

		y = y.replace("ευγ", "evγ");
		y = y.replace("Ευγ", "Evγ");
		y = y.replace("εΥγ", "eVγ");
		y = y.replace("ευΓ", "evΓ");
		y = y.replace("ΕΥγ", "EVγ");
		y = y.replace("εΥΓ", "eVΓ");
		y = y.replace("ΕυΓ", "EvΓ");
		y = y.replace("ΕΥΓ", "EVΓ");

		y = y.replace("ευδ", "evδ");
		y = y.replace("Ευδ", "Evδ");
		y = y.replace("εΥδ", "eVδ");
		y = y.replace("ευΔ", "evΔ");
		y = y.replace("ΕΥδ", "EVδ");
		y = y.replace("εΥΔ", "eVΔ");
		y = y.replace("ΕυΔ", "EvΔ");
		y = y.replace("ΕΥΔ", "EVΔ");

		y = y.replace("ευε", "evε");
		y = y.replace("Ευε", "Evε");
		y = y.replace("εΥε", "eVε");
		y = y.replace("ευΕ", "evΕ");
		y = y.replace("ΕΥε", "EVε");
		y = y.replace("εΥΕ", "eVΕ");
		y = y.replace("ΕυΕ", "EvΕ");
		y = y.replace("ΕΥΕ", "EVΕ");

		y = y.replace("ευζ", "evζ");
		y = y.replace("Ευζ", "Evζ");
		y = y.replace("εΥζ", "eVζ");
		y = y.replace("ευΖ", "evΖ");
		y = y.replace("ΕΥζ", "EVζ");
		y = y.replace("εΥΖ", "eVΖ");
		y = y.replace("ΕυΖ", "EvΖ");
		y = y.replace("ΕΥΖ", "EVΖ");

		y = y.replace("ευη", "evη");
		y = y.replace("Ευη", "Evη");
		y = y.replace("εΥη", "eVη");
		y = y.replace("ευΗ", "evΗ");
		y = y.replace("ΕΥη", "EVη");
		y = y.replace("εΥΗ", "eVΗ");
		y = y.replace("ΕυΗ", "EvΗ");
		y = y.replace("ΕΥΗ", "EVΗ");

		y = y.replace("ευθ", "efθ");
		y = y.replace("Ευθ", "Efθ");
		y = y.replace("εΥθ", "eFθ");
		y = y.replace("ευΘ", "efΘ");
		y = y.replace("ΕΥθ", "EFθ");
		y = y.replace("εΥΘ", "eFΘ");
		y = y.replace("ΕυΘ", "EfΘ");
		y = y.replace("ΕΥΘ", "EFΘ");

		y = y.replace("ευι", "evι");
		y = y.replace("Ευι", "Evι");
		y = y.replace("εΥι", "eVι");
		y = y.replace("ευΙ", "evΙ");
		y = y.replace("ΕΥι", "EVι");
		y = y.replace("εΥΙ", "eVΙ");
		y = y.replace("ΕυΙ", "EvΙ");
		y = y.replace("ΕΥΙ", "EVΙ");

		y = y.replace("ευκ", "efκ");
		y = y.replace("Ευκ", "Efκ");
		y = y.replace("εΥκ", "eFκ");
		y = y.replace("ευΚ", "efΚ");
		y = y.replace("ΕΥκ", "EFκ");
		y = y.replace("εΥΚ", "eFΚ");
		y = y.replace("ΕυΚ", "EfΚ");
		y = y.replace("ΕΥΚ", "EFΚ");

		y = y.replace("ευλ", "evλ");
		y = y.replace("Ευλ", "Evλ");
		y = y.replace("εΥλ", "eVλ");
		y = y.replace("ευΛ", "evΛ");
		y = y.replace("ΕΥλ", "EVλ");
		y = y.replace("εΥΛ", "eVΛ");
		y = y.replace("ΕυΛ", "EvΛ");
		y = y.replace("ΕΥΛ", "EVΛ");

		y = y.replace("ευμ", "evμ");
		y = y.replace("Ευμ", "Evμ");
		y = y.replace("εΥμ", "eVμ");
		y = y.replace("ευΜ", "evΜ");
		y = y.replace("ΕΥμ", "EVμ");
		y = y.replace("εΥΜ", "eVΜ");
		y = y.replace("ΕυΜ", "EvΜ");
		y = y.replace("ΕΥΜ", "EVΜ");

		y = y.replace("ευν", "evν");
		y = y.replace("Ευν", "Evν");
		y = y.replace("εΥν", "eVν");
		y = y.replace("ευΝ", "evΝ");
		y = y.replace("ΕΥν", "EVν");
		y = y.replace("εΥΝ", "eVΝ");
		y = y.replace("ΕυΝ", "EvΝ");
		y = y.replace("ΕΥΝ", "EVΝ");

		y = y.replace("ευξ", "efξ");
		y = y.replace("Ευξ", "Efξ");
		y = y.replace("εΥξ", "eFξ");
		y = y.replace("ευΞ", "efΞ");
		y = y.replace("ΕΥξ", "EFξ");
		y = y.replace("εΥΞ", "eFΞ");
		y = y.replace("ΕυΞ", "EfΞ");
		y = y.replace("ΕΥΞ", "EFΞ");

		y = y.replace("ευο", "evο");
		y = y.replace("Ευο", "Evο");
		y = y.replace("εΥο", "eVο");
		y = y.replace("ευΟ", "evΟ");
		y = y.replace("ΕΥο", "EVο");
		y = y.replace("εΥΟ", "eVΟ");
		y = y.replace("ΕυΟ", "EvΟ");
		y = y.replace("ΕΥΟ", "EVΟ");

		y = y.replace("ευπ", "efπ");
		y = y.replace("Ευπ", "Efπ");
		y = y.replace("εΥπ", "eFπ");
		y = y.replace("ευΠ", "efΠ");
		y = y.replace("ΕΥπ", "EFπ");
		y = y.replace("εΥΠ", "eFΠ");
		y = y.replace("ΕυΠ", "EfΠ");
		y = y.replace("ΕΥΠ", "EFΠ");

		y = y.replace("ευρ", "evρ");
		y = y.replace("Ευρ", "Evρ");
		y = y.replace("εΥρ", "eVρ");
		y = y.replace("ευΡ", "evΡ");
		y = y.replace("ΕΥρ", "EVρ");
		y = y.replace("εΥΡ", "eVΡ");
		y = y.replace("ΕυΡ", "EvΡ");
		y = y.replace("ΕΥΡ", "EVΡ");

		y = y.replace("ευσ", "efσ");
		y = y.replace("Ευσ", "Efσ");
		y = y.replace("εΥσ", "eFσ");
		y = y.replace("ευΣ", "efΣ");
		y = y.replace("ΕΥσ", "EFσ");
		y = y.replace("εΥΣ", "eFΣ");
		y = y.replace("ΕυΣ", "EfΣ");
		y = y.replace("ΕΥΣ", "EFΣ");
		y = y.replace("ευς", "efς");
		y = y.replace("Ευς", "Efς");
		y = y.replace("εΥς", "eFς");
		y = y.replace("ΕΥς", "EFς");

		y = y.replace("ευτ", "efτ");
		y = y.replace("Ευτ", "Efτ");
		y = y.replace("εΥτ", "eFτ");
		y = y.replace("ευΤ", "efΤ");
		y = y.replace("ΕΥτ", "EFτ");
		y = y.replace("εΥΤ", "eFΤ");
		y = y.replace("ΕυΤ", "EfΤ");
		y = y.replace("ΕΥΤ", "EFΤ");

		y = y.replace("ευφ", "ef");
		y = y.replace("Ευφ", "Ef");
		y = y.replace("εΥφ", "eF");
		y = y.replace("ευΦ", "eF");
		y = y.replace("ΕΥφ", "EF");
		y = y.replace("εΥΦ", "eF");
		y = y.replace("ΕυΦ", "EF");
		y = y.replace("ΕΥΦ", "EF");

		y = y.replace("ευχ", "efχ");
		y = y.replace("Ευχ", "Efχ");
		y = y.replace("εΥχ", "eFχ");
		y = y.replace("ευΧ", "efΧ");
		y = y.replace("ΕΥχ", "EFχ");
		y = y.replace("εΥΧ", "eFΧ");
		y = y.replace("ΕυΧ", "EfΧ");
		y = y.replace("ΕΥΧ", "EFΧ");

		y = y.replace("ευψ", "efψ");
		y = y.replace("Ευψ", "Efψ");
		y = y.replace("εΥψ", "eFψ");
		y = y.replace("ευΨ", "efΨ");
		y = y.replace("ΕΥψ", "EFψ");
		y = y.replace("εΥΨ", "eFΨ");
		y = y.replace("ΕυΨ", "EfΨ");
		y = y.replace("ΕΥΨ", "EFΨ");

		y = y.replace("ευω", "evω");
		y = y.replace("Ευω", "Evω");
		y = y.replace("εΥω", "eVω");
		y = y.replace("ευΩ", "evΩ");
		y = y.replace("ΕΥω", "EVω");
		y = y.replace("εΥΩ", "eVΩ");
		y = y.replace("ΕυΩ", "EvΩ");
		y = y.replace("ΕΥΩ", "EVΩ");
		y = y.replace("ηυα", "ivα");
		y = y.replace("Ηυα", "Ivα");
		y = y.replace("ηΥα", "iVα");
		y = y.replace("ηυΑ", "ivA");
		y = y.replace("ΗΥα", "IVα");
		y = y.replace("ηΥΑ", "iVΑ");
		y = y.replace("ΗυΑ", "IvΑ");
		y = y.replace("ΗΥΑ", "IVΑ");

		y = y.replace("ηυβ", "iv");
		y = y.replace("Ηυβ", "Iv");
		y = y.replace("ηΥβ", "iV");
		y = y.replace("ηυΒ", "iV");
		y = y.replace("ΗΥβ", "IV");
		y = y.replace("ηΥΒ", "iV");
		y = y.replace("ΗυΒ", "IV");
		y = y.replace("ΗΥΒ", "IV");

		y = y.replace("ηυγ", "ivγ");
		y = y.replace("Ηυγ", "Ivγ");
		y = y.replace("ηΥγ", "iVγ");
		y = y.replace("ηυΓ", "ivΓ");
		y = y.replace("ΗΥγ", "IVγ");
		y = y.replace("ηΥΓ", "iVΓ");
		y = y.replace("ΗυΓ", "IvΓ");
		y = y.replace("ΗΥΓ", "IVΓ");

		y = y.replace("ηυδ", "ivδ");
		y = y.replace("Ηυδ", "Ivδ");
		y = y.replace("ηΥδ", "iVδ");
		y = y.replace("ηυΔ", "ivΔ");
		y = y.replace("ΗΥδ", "IVδ");
		y = y.replace("ηΥΔ", "iVΔ");
		y = y.replace("ΗυΔ", "IvΔ");
		y = y.replace("ΗΥΔ", "IVΔ");

		y = y.replace("ηυε", "ivε");
		y = y.replace("Ηυε", "Ivε");
		y = y.replace("ηΥε", "iVε");
		y = y.replace("ηυΕ", "ivΕ");
		y = y.replace("ΗΥε", "IVε");
		y = y.replace("ηΥΕ", "iVΕ");
		y = y.replace("ΗυΕ", "IvΕ");
		y = y.replace("ΗΥΕ", "IVΕ");

		y = y.replace("ηυζ", "ivζ");
		y = y.replace("Ηυζ", "Ivζ");
		y = y.replace("ηΥζ", "iVζ");
		y = y.replace("ηυΖ", "ivΖ");
		y = y.replace("ΗΥζ", "IVζ");
		y = y.replace("ηΥΖ", "iVΖ");
		y = y.replace("ΗυΖ", "IvΖ");
		y = y.replace("ΗΥΖ", "IVΖ");

		y = y.replace("ηυη", "ivη");
		y = y.replace("Ηυη", "Ivη");
		y = y.replace("ηΥη", "iVη");
		y = y.replace("ηυΗ", "ivΗ");
		y = y.replace("ΗΥη", "IVη");
		y = y.replace("ηΥΗ", "iVΗ");
		y = y.replace("ΗυΗ", "IvΗ");
		y = y.replace("ΗΥΗ", "IVΗ");

		y = y.replace("ηυθ", "ifθ");
		y = y.replace("Ηυθ", "Ifθ");
		y = y.replace("ηΥθ", "iFθ");
		y = y.replace("ηυΘ", "ifΘ");
		y = y.replace("ΗΥθ", "IFθ");
		y = y.replace("ηΥΘ", "iFΘ");
		y = y.replace("ΗυΘ", "IfΘ");
		y = y.replace("ΗΥΘ", "IFΘ");

		y = y.replace("ηυι", "ivι");
		y = y.replace("Ηυι", "Ivι");
		y = y.replace("ηΥι", "iVι");
		y = y.replace("ηυΙ", "ivΙ");
		y = y.replace("ΗΥι", "IVι");
		y = y.replace("ηΥΙ", "iVΙ");
		y = y.replace("ΗυΙ", "IvΙ");
		y = y.replace("ΗΥΙ", "IVΙ");

		y = y.replace("ηυκ", "ifκ");
		y = y.replace("Ηυκ", "Ifκ");
		y = y.replace("ηΥκ", "iFκ");
		y = y.replace("ηυΚ", "ifΚ");
		y = y.replace("ΗΥκ", "IFκ");
		y = y.replace("ηΥΚ", "iFΚ");
		y = y.replace("ΗυΚ", "IfΚ");
		y = y.replace("ΗΥΚ", "IFΚ");

		y = y.replace("ηυλ", "ivλ");
		y = y.replace("Ηυλ", "Ivλ");
		y = y.replace("ηΥλ", "iVλ");
		y = y.replace("ηυΛ", "ivΛ");
		y = y.replace("ΗΥλ", "IVλ");
		y = y.replace("ηΥΛ", "iVΛ");
		y = y.replace("ΗυΛ", "IvΛ");
		y = y.replace("ΗΥΛ", "IVΛ");

		y = y.replace("ηυμ", "ivμ");
		y = y.replace("Ηυμ", "Ivμ");
		y = y.replace("ηΥμ", "iVμ");
		y = y.replace("ηυΜ", "ivΜ");
		y = y.replace("ΗΥμ", "IVμ");
		y = y.replace("ηΥΜ", "iVΜ");
		y = y.replace("ΗυΜ", "IvΜ");
		y = y.replace("ΗΥΜ", "IVΜ");

		y = y.replace("ηυν", "ivν");
		y = y.replace("Ηυν", "Ivν");
		y = y.replace("ηΥν", "iVν");
		y = y.replace("ηυΝ", "ivΝ");
		y = y.replace("ΗΥν", "IVν");
		y = y.replace("ηΥΝ", "iVΝ");
		y = y.replace("ΗυΝ", "IvΝ");
		y = y.replace("ΗΥΝ", "IVΝ");

		y = y.replace("ηυξ", "ifξ");
		y = y.replace("Ηυξ", "Ifξ");
		y = y.replace("ηΥξ", "iFξ");
		y = y.replace("ηυΞ", "ifΞ");
		y = y.replace("ΗΥξ", "IFξ");
		y = y.replace("ηΥΞ", "iFΞ");
		y = y.replace("ΗυΞ", "IfΞ");
		y = y.replace("ΗΥΞ", "IFΞ");

		y = y.replace("ηυο", "ivο");
		y = y.replace("Ηυο", "Ivο");
		y = y.replace("ηΥο", "iVο");
		y = y.replace("ηυΟ", "ivΟ");
		y = y.replace("ΗΥο", "IVο");
		y = y.replace("ηΥΟ", "iVΟ");
		y = y.replace("ΗυΟ", "IvΟ");
		y = y.replace("ΗΥΟ", "IVΟ");

		y = y.replace("ηυπ", "ifπ");
		y = y.replace("Ηυπ", "Ifπ");
		y = y.replace("ηΥπ", "iFπ");
		y = y.replace("ηυΠ", "ifΠ");
		y = y.replace("ΗΥπ", "IFπ");
		y = y.replace("ηΥΠ", "iFΠ");
		y = y.replace("ΗυΠ", "IfΠ");
		y = y.replace("ΗΥΠ", "IFΠ");

		y = y.replace("ηυρ", "ivρ");
		y = y.replace("Ηυρ", "Ivρ");
		y = y.replace("ηΥρ", "iVρ");
		y = y.replace("ηυΡ", "ivΡ");
		y = y.replace("ΗΥρ", "IVρ");
		y = y.replace("ηΥΡ", "iVΡ");
		y = y.replace("ΗυΡ", "IvΡ");
		y = y.replace("ΗΥΡ", "IVΡ");

		y = y.replace("ηυσ", "ifσ");
		y = y.replace("Ηυσ", "Ifσ");
		y = y.replace("ηΥσ", "iFσ");
		y = y.replace("ηυΣ", "ifΣ");
		y = y.replace("ΗΥσ", "IFσ");
		y = y.replace("ηΥΣ", "iFΣ");
		y = y.replace("ΗυΣ", "IfΣ");
		y = y.replace("ΗΥΣ", "IFΣ");
		y = y.replace("ηυς", "ifς");
		y = y.replace("Ηυς", "Ifς");
		y = y.replace("ηΥς", "iFς");
		y = y.replace("ΗΥς", "IFς");

		y = y.replace("ηυτ", "ifτ");
		y = y.replace("Ηυτ", "Ifτ");
		y = y.replace("ηΥτ", "iFτ");
		y = y.replace("ηυΤ", "ifΤ");
		y = y.replace("ΗΥτ", "IFτ");
		y = y.replace("ηΥΤ", "iFΤ");
		y = y.replace("ΗυΤ", "IfΤ");
		y = y.replace("ΗΥΤ", "IFΤ");

		y = y.replace("ηυφ", "if");
		y = y.replace("Ηυφ", "If");
		y = y.replace("ηΥφ", "iF");
		y = y.replace("ηυΦ", "iF");
		y = y.replace("ΗΥφ", "IF");
		y = y.replace("ηΥΦ", "iF");
		y = y.replace("ΗυΦ", "IF");
		y = y.replace("ΗΥΦ", "IF");

		y = y.replace("ηυχ", "ifχ");
		y = y.replace("Ηυχ", "Ifχ");
		y = y.replace("ηΥχ", "iFχ");
		y = y.replace("ηυΧ", "ifΧ");
		y = y.replace("ΗΥχ", "IFχ");
		y = y.replace("ηΥΧ", "iFΧ");
		y = y.replace("ΗυΧ", "IfΧ");
		y = y.replace("ΗΥΧ", "IFΧ");

		y = y.replace("ηυψ", "ifψ");
		y = y.replace("Ηυψ", "Ifψ");
		y = y.replace("ηΥψ", "iFψ");
		y = y.replace("ηυΨ", "ifΨ");
		y = y.replace("ΗΥψ", "IFψ");
		y = y.replace("ηΥΨ", "iFΨ");
		y = y.replace("ΗυΨ", "IfΨ");
		y = y.replace("ΗΥΨ", "IFΨ");

		y = y.replace("ηυω", "ivω");
		y = y.replace("Ηυω", "Ivω");
		y = y.replace("ηΥω", "iVω");
		y = y.replace("ηυΩ", "ivΩ");
		y = y.replace("ΗΥω", "IVω");
		y = y.replace("ηΥΩ", "iVΩ");
		y = y.replace("ΗυΩ", "IvΩ");
		y = y.replace("ΗΥΩ", "IVΩ");
		// ‘αι
		y = y.replace("αι", "ai");
		y = y.replace("Αι", "Ai");
		y = y.replace("αΙ", "aI");
		y = y.replace("ΑΙ", "AI");
		// ‘αϊ
		y = y.replace("αϊ", "aï");
		y = y.replace("Αϊ", "Aï");
		y = y.replace("αΪ", "aÏ");
		y = y.replace("ΑΪ", "AÏ");
		// ‘γγ
		y = y.replace("γγ", "ng");
		y = y.replace("Γγ", "Ng");
		y = y.replace("γΓ", "nG");
		y = y.replace("ΓΓ", "NG");
		// ‘γκ
		y = y.replace("γκ", "gk");
		y = y.replace("Γκ", "Gk");
		y = y.replace("γΚ", "gK");
		y = y.replace("ΓΚ", "GK");
		// ‘γξ
		y = y.replace("γξ", "nx");
		y = y.replace("Γξ", "Nx");
		y = y.replace("γΞ", "nX");
		y = y.replace("ΓΞ", "NX");
		// ‘γχ
		y = y.replace("γχ", "nch");
		y = y.replace("Γχ", "Nch");
		y = y.replace("γΧ", "nCH");
		y = y.replace("ΓΧ", "NCH");
		// ‘ει
		y = y.replace("ει", "ei");
		y = y.replace("Ει", "Ei");
		y = y.replace("εΙ", "eI");
		y = y.replace("ΕΙ", "EI");
		// ‘εϊ
		y = y.replace("εϊ", "eï");
		y = y.replace("Εϊ", "Eï");
		y = y.replace("εΪ", "eÏ");
		y = y.replace("ΕΪ", "EÏ");
		// ‘μπ
		y = y.replace("μπ", "b");
		y = y.replace("Μπ", "Mp");
		y = y.replace("μΠ", "mP");
		y = y.replace("ΜΠ", "B");
		// ‘ντ
		y = y.replace("ντ", "nt");
		y = y.replace("Ντ", "Nt");
		y = y.replace("νΤ", "nT");
		y = y.replace("ΝΤ", "NT");
		// ‘οι
		y = y.replace("οι", "oi");
		y = y.replace("Οι", "Oi");
		y = y.replace("οΙ", "oI");
		y = y.replace("ΟΙ", "OI");
		// ‘οϊ
		y = y.replace("οϊ", "oï");
		y = y.replace("Οϊ", "Oï");
		y = y.replace("οΪ", "oÏ");
		y = y.replace("ΟΪ", "OÏ");
		// ‘ου
		y = y.replace("ου", "ou");
		y = y.replace("Ου", "Ou");
		y = y.replace("οΥ", "oY");
		y = y.replace("ΟΥ", "OY");
		// ‘υι
		y = y.replace("υι", "yi");
		y = y.replace("Yι", "Yi");
		y = y.replace("υI", "yI");
		y = y.replace("YI", "YI");
		y = y.replace("α", "a");
		y = y.replace("Α", "A");
		y = y.replace("β", "v");
		y = y.replace("Β", "V");
		y = y.replace("γ", "g");
		y = y.replace("Γ", "G");
		y = y.replace("δ", "d");
		y = y.replace("Δ", "D");
		y = y.replace("ε", "e");
		y = y.replace("Ε", "E");
		y = y.replace("ζ", "z");
		y = y.replace("Ζ", "Z");
		y = y.replace("η", "i");
		y = y.replace("Η", "I");
		y = y.replace("θ", "th");
		y = y.replace("Θ", "Th");
		y = y.replace("ι", "i");
		y = y.replace("Ι", "I");
		y = y.replace("κ", "k");
		y = y.replace("Κ", "K");
		y = y.replace("λ", "l");
		y = y.replace("Λ", "L");
		y = y.replace("μ", "m");
		y = y.replace("Μ", "M");
		y = y.replace("ν", "n");
		y = y.replace("Ν", "N");
		y = y.replace("ξ", "x");
		y = y.replace("Ξ", "X");
		y = y.replace("ο", "o");
		y = y.replace("Ο", "O");
		y = y.replace("π", "p");
		y = y.replace("Π", "P");
		y = y.replace("ρ", "r");
		y = y.replace("Ρ", "R");
		y = y.replace("σ", "s");
		y = y.replace("Σ", "S");
		y = y.replace("ς", "s");
		y = y.replace("τ", "t");
		y = y.replace("Τ", "T");
		y = y.replace("υ", "y");
		y = y.replace("Υ", "Y");
		y = y.replace("φ", "f");
		y = y.replace("Φ", "F");
		y = y.replace("χ", "ch");
		y = y.replace("Χ", "Ch");
		y = y.replace("ψ", "ps");
		y = y.replace("Ψ", "Ps");
		y = y.replace("ω", "o");
		y = y.replace("Ω", "O");
		y = y.replaceAll("_+", "_");
		return y;
	}

	private static Character removegreektones(Character inp_char) {
		if (Character.isSpaceChar(inp_char) || !Character.isLetterOrDigit(inp_char)) {
			return '_';
		} else if (inp_char == 'ά') {
			return 'a';
		} else if (inp_char == 'έ') {
			return 'e';
		} else if (inp_char == 'ή') {
			return 'i';
		} else if (inp_char == 'ί') {
			return 'i';
		} else if (inp_char == 'ϊ') {
			return 'i';
		} else if (inp_char == 'ΐ') {
			return 'i';
		} else if (inp_char == 'ό') {
			return 'o';
		} else if (inp_char == 'ύ') {
			return 'y';
		} else if (inp_char == 'ϋ') {
			return 'y';
		} else if (inp_char == 'ΰ') {
			return 'y';
		} else if (inp_char == 'ώ') {
			return 'o';
		} else
			return inp_char;
	}
}
