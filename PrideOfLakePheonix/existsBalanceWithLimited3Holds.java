	public static boolean existsBalanceWithLimited3Holds(int[] container, int limit, int divergence, int unitsLoaded 
			,int holdsLimit , int leftAnzahl, int midAnzahl, int rightAnzahl) {
		if (unitsLoaded >= container.length) {
			return divergence == 0;
		}
		if ( Math.abs(divergence) > limit) {
			return false;
		}
		if (leftAnzahl >= holdsLimit || midAnzahl >= holdsLimit || rightAnzahl>= holdsLimit) {
			return false;
		}
		if ( 	// links Überprüfen -> divergence erhöht sich und Linkerlagerplatz um 1 voller
				existsBalanceWithLimited3Holds(container, limit , divergence+container[unitsLoaded], unitsLoaded+=1,
				holdsLimit, leftAnzahl+1, midAnzahl , rightAnzahl)
				// oder ! rechts Überprüfen -> divergence wird kleiner und Rechterlagerplatz um 1 voller
				|| existsBalanceWithLimited3Holds(container, limit , divergence-container[unitsLoaded], unitsLoaded+=1,
				holdsLimit, leftAnzahl, midAnzahl, rightAnzahl+1)
				// oder ! wenn nichts passt  in der mitte rein legen  Keine divergence unterschied und MittlererLagerplatz wird um 1 voller
				|| existsBalanceWithLimited3Holds(container, limit , divergence, unitsLoaded+=1, 
				holdsLimit, leftAnzahl, midAnzahl +1,rightAnzahl)
				) {
			return true;
		}
		return false;
	}
