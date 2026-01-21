import re
import os

md_path = r"e:\dsaCrashCourse\COMPANY_WISE_QUESTIONS.md"
base_dir = r"e:\dsaCrashCourse"

with open(md_path, 'r', encoding='utf-8') as f:
    content = f.read()

links = re.findall(r'\]\((src/[^)]+)\)', content)

missing = []
print(f"Checking {len(links)} links...")

for link in links:
    # Convert forward slashes to backslashes for Windows if needed, though Python handles / fine usually.
    full_path = os.path.join(base_dir, link)
    if not os.path.exists(full_path):
        missing.append(link)

if not missing:
    print("SUCCESS: All links are valid.")
else:
    print(f"FAILURE: Found {len(missing)} missing files:")
    for m in missing:
        print(m)
