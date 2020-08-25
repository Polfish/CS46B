package dna;

import java.awt.print.PrinterAbortException;
import java.io.*;
import java.util.*;

/**
 * This class converts fastq files to fasta files
 * It only adds records that don't have a low quality
 */
public class FileConverter {
    private File fastq;
    private File fasta;

    public FileConverter(File fastq, File fasta) {
        this.fastq = fastq;
        this.fasta = fasta;
    }

    /**
     * Converts from fastq to fasta only if the quality is not low
     * @throws IOException if file not found or other IO exception
     */
    public void convert() throws IOException {
    	
    	// Build the readers.
    	FileReader fr = new FileReader(fastq);
    	BufferedReader br = new BufferedReader(fr);
    	FastqReader fqr = new FastqReader(br);
    	
    	// Build the writers.
    	FileWriter fw = new FileWriter(fasta);
    	PrintWriter pw = new PrintWriter(fw);
    	FastaWriter faw = new FastaWriter(pw);
    	
    	// Read the fastq file
    	// Then, translate and write it into the fasta file
    	boolean endOfFile = false;
    	while(!endOfFile) {
    		FastqRecord fastqRecord = null;
    		try {
    			fastqRecord = fqr.readRecord();
    			if (fastqRecord == null) {
    				endOfFile = true;
    			}
    			else if(!fastqRecord.qualityIsLow()){
    				FastaRecord fastaRecord = new FastaRecord(fastqRecord);
    				faw.writeRecord(fastaRecord);
    			}
    		} catch (RecordFormatException e) {
    			e.getMessage();
    		}
    	}

    	// Close all readers and writers in reverse order of creation.
    	pw.close();
        fw.close();
        br.close();
        fr.close();
    }

    /**
     * Tests the FileConverter class.
     */
    public static void main(String[] args) {
        System.out.println("Starting");
        try {
            File fastq = new File("data/HW4.fastq");
            if (!fastq.exists()) {
                System.out.println("Can't find input file " + fastq.getAbsolutePath());
                System.exit(1);
            }
            File fasta = new File("data/HW4.fasta");
            FileConverter converter = new FileConverter(fastq, fasta);
            converter.convert();
        } catch (IOException x) {
            System.out.println(x.getMessage());
        }
        System.out.println("Done");
    }
}
