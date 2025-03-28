package elementsOfProgramming.Strings;

import java.util.ArrayList;
import java.util.List;

public class ComputeAllValidIPAddressIteration {

	public static void main(String[] args) {
		String address = "19216811";
		List< String > result = new ArrayList<>();
		computeValidIp( address, result );

		for( String ip : result ) {
			System.out.println( ip );
		}
	}

	private static void computeValidIp(String address, List<String> result) {

		if( address.length() < 4 ) {
			return;
		}

		for( int i = 0; i < 3 && i < address.length() - 3; i++ ) {
			String firstPart = address.substring( 0, i + 1 );

			if( !validateIpPart( firstPart ) ) {
				continue;
			}

			for( int j = i + 1; j <= i + 3 && j < address.length() - 2; j++ ) {
				String secondPart = address.substring( i + 1, j + 1 );

				if( !validateIpPart( secondPart ) ) {
					continue;
				}

				for( int k = j + 1; k <= j + 3 && k < address.length() - 1; k++ ) {
					String thirdPart = address.substring( j + 1, k + 1 );
					String fourthPart = address.substring( k + 1 );

					if( validateIpPart( fourthPart) && validateIpPart( thirdPart) ) {
						result.add( firstPart + "." + secondPart + "." + thirdPart + "." +
								fourthPart );
					}
				}
			}
		}
	}


	private static boolean validateIpPart( String ipPart ) {

		if( ipPart.length() > 1 && ipPart.startsWith("0") ) {
			return false;
		}
		int ipPartNum = Integer.parseInt( ipPart );

		if( ipPartNum > 255 || ipPartNum < 0 ) {
			return false;
		}
		return true;
	}

}
