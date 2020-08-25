package dna;

import java.io.*;

/**
 * Reads lines using a BufferedReader and then creates a FastqRecord.
 */
public class FastqReader {
	private BufferedReader theBufferedReader;

	public FastqReader(BufferedReader theBufferedReader) {
		this.theBufferedReader = theBufferedReader;
	}
	/**
	 * Reads the defline using the BufferedReader.
	 * @return null if you read null or a FastqRecord if not null
	 * @throws IOException if file not found or some other IO exception occurred
	 * @throws RecordFormatException if the FastqRecord is constructed incorrectly
	 */
	public FastqRecord readRecord() throws IOException, RecordFormatException {
		String defline = theBufferedReader.readLine();
		String sequence = "";
		String plus = "";
		String quality = "";
		if (defline == null)
			return null;
		// if the defline is not null,
		// read the next 3 lines from the buffered reader.
		// Then, construct and return a FastqRecord.
		else {
			sequence = theBufferedReader.readLine();
			plus = theBufferedReader.readLine();
			quality = theBufferedReader.readLine();
			return new FastqRecord(defline, sequence, quality);
		}
	}
}
