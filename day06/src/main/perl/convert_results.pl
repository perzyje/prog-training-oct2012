#!/usr/bin/perl
use utf8;
use v5.12;
use strict;
use warnings;
use warnings  qw(FATAL utf8);
use open      qw(:std :utf8);

my $PREFIX = 'string';
my $first = 1;

while (<>) {
	chomp;
	$_ = (split /\t/)[0];
	my @p = split / \x{2192} /;
	if ($first) {
		print "\@Test\npublic void test", ucfirst($p[0]), "() {\n";
		$first = 0;
	}
	if ($p[1] eq 'true') {
		print "assertTrue($PREFIX.$p[0]);\n";
	}
	elsif ($p[1] eq 'false') {
		print "assertFalse($PREFIX.$p[0]);\n";
	}
	else {
		print "assertEquals($p[1], $PREFIX.$p[0]);\n";
	}
}
print "}\n";
