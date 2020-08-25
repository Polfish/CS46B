package dna;

import java.io.*;

/**
 * Writes a fasta record to a print writer.
 */
public class FastaWriter {
	private PrintWriter thePrintWriter;

	public FastaWriter(PrintWriter thePrintWriter) {
		this.thePrintWriter = thePrintWriter;
	}
	
    /**
     * Prints out the fasta record into 2 lines: the defline, then the sequence
     * @param rec the FastaRecord to print out
     * @throws IOException if file not found or some other IO exception
     */
    public void writeRecord(FastaRecord rec) throws IOException {
		thePrintWriter.println(rec.getDefline());
		thePrintWriter.println(rec.getSequence());
    }
}
