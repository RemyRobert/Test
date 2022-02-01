package com.yoann.calcul;
import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * @author Remy Robert
 *
 */
@RunWith(Parameterized.class)
class CalculsTest3 {

	static Stream<Arguments> jeuDeTestTriCroissant() throws Throwable 
    {
        return Stream.of(
        	Arguments.of(new int[]{5, 6, 2, 15},new int[]{2, 5, 6, 15}),
            Arguments.of(new int[]{5, 3, 2},new int[]{2, 3, 5}),
            Arguments.of(new int[]{11, 12, 13},new int[]{11, 12, 13}),
            Arguments.of(new int[]{20,-1,3},new int[]{-1, 3, 20})
        );
    }
	
	static Stream<Arguments> jeuDeTestTriDecroissant() throws Throwable 
    {
        return Stream.of(
            Arguments.of(new int[]{11, 12, 13},new int[]{13, 12, 11}),
            Arguments.of(new int[]{20,-1,3},new int[]{20, 3, -1}),
            Arguments.of(new int[]{5,4,3,2,1,0},new int[]{5,4,3,2,1,0}),
            Arguments.of(new int[]{55,44,33,11,22,0},new int[]{55,44,33,22,11,0})
        );
    }

	@ParameterizedTest(name="Tri du tableau croissant numéro {index}: tableau={0}, résultat attendu = {1}")
	@MethodSource("jeuDeTestTriCroissant")
	void testTriCroissant(int tableau[], int expectedResult[]) 
	{
		//Act
		TriTableau.triCroissant(tableau);
		
		//Assert
		for (int i = 0; i < tableau.length; i++) {
			assertEquals(expectedResult[i], tableau[i], "test en échec pour " + tableau[i] + " != " + expectedResult[i]);
		} 
	}
	
	@ParameterizedTest(name="Tri du tableau decroissant numéro {index}: tableau={0}, résultat attendu = {1}")
	@MethodSource("jeuDeTestTriDecroissant")
	void testTriDecroissant(int tableau[], int expectedResult[]) 
	{
		//Act
		TriTableau.triDecroissant(tableau);
		
		//Les tests ne vont pas passer car il manque un -1 dans le boucle du tri décroissant sur la longueur
		
		//Assert
		for (int i = 0; i < tableau.length; i++) {
			assertEquals(expectedResult[i], tableau[i], "test en échec pour " + tableau[i] + " != " + expectedResult[i]);
		} 
	}
}
